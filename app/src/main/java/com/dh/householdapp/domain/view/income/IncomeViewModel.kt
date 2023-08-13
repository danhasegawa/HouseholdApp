package com.dh.householdapp.domain.view.income

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dh.householdapp.data.usecases.GetAllExpensesByDateUseCase
import com.dh.householdapp.data.usecases.income.DeleteIncomeUseCase
import com.dh.householdapp.data.usecases.income.GetAllIncomeByDescriptionUseCase
import com.dh.householdapp.data.usecases.income.GetAllIncomeByValueUseCase
import com.dh.householdapp.data.usecases.income.GetAllIncomeUseCase
import com.dh.householdapp.data.usecases.income.UpsertIncomeUseCase
import com.dh.householdapp.domain.model.Income
import com.dh.householdapp.domain.sort.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class IncomeViewModel @Inject constructor(
    private val upsertIncomeUseCase: UpsertIncomeUseCase,
    private val deleteIncomeUseCase: DeleteIncomeUseCase,
    private val getAllIncomeUseCase: GetAllIncomeUseCase,
    private val getAllIncomeByDescriptionUseCase: GetAllIncomeByDescriptionUseCase,
    private val getAllIncomeByValueUseCase: GetAllIncomeByValueUseCase,
    private val getAllIncomeByDateUseCase: GetAllExpensesByDateUseCase
) : ViewModel() {

    private val _sortType = MutableStateFlow(SortType.DESCRIPTION)
    private val _incomes = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                SortType.ALL -> getAllIncomeUseCase()
                SortType.DESCRIPTION -> getAllIncomeByDescriptionUseCase()
                SortType.VALUE -> getAllIncomeByValueUseCase()
                SortType.DATE -> getAllIncomeByDateUseCase()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(IncomeState())

    val state = combine(
        _state,
        _sortType,
        _incomes
    ) { state, sortType, incomes ->
        state.copy(
            incomes = incomes as List<Income>,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), IncomeState())

    fun onEvent(event: IncomeEvent) {
        when (event) {
            is IncomeEvent.DeleteIncome -> {
                viewModelScope.launch {
                    deleteIncomeUseCase(event.income)
                }
            }

            IncomeEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingIncome = false
                    )
                }
            }

            IncomeEvent.SaveIncome -> {
                val description = state.value.description
                val value = state.value.value
                val date = state.value.date

                if (description.isBlank()) {
                    return
                }
                val income = Income(
                    description = description,
                    value = value,
                    date = date
                )
                viewModelScope.launch {
                    upsertIncomeUseCase(income = income)
                }
                _state.update {
                    it.copy(
                        isAddingIncome = false,
                        description = "",
                        value = "",
                        date = ""
                    )
                }
            }

            is IncomeEvent.SetDate -> {
                _state.update {
                    it.copy(
                        date = event.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    )
                }
            }

            is IncomeEvent.SetDescription -> {
                _state.update {
                    it.copy(description = event.description)
                }
            }

            is IncomeEvent.SetValue -> {
                _state.update {
                    it.copy(value = event.value)
                }
            }

            IncomeEvent.ShowDialog -> {
                _state.update {
                    it.copy(isAddingIncome = true)
                }
            }

            is IncomeEvent.SortIncome -> {
                _sortType.value = event.sortType
            }

        }
    }

}


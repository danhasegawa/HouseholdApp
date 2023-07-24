package com.dh.householdapp.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dh.householdapp.data.repository.ExpenseRepository
import com.dh.householdapp.domain.model.Expense
import com.dh.householdapp.domain.sort.SortType
import com.dh.householdapp.domain.view.ExpenseEvent
import com.dh.householdapp.domain.view.ExpenseState
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


@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val expenseRepository: ExpenseRepository
) : ViewModel() {

    private val _sortType = MutableStateFlow(SortType.DESCRIPTION)
    private val _expenses = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                SortType.DESCRIPTION -> expenseRepository.getExpenseByDescription()
                SortType.VALUE -> expenseRepository.getExpenseByValue()
                SortType.DATE -> expenseRepository.getExpenseByDate()
                SortType.ALL -> expenseRepository.getAllExpense()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(ExpenseState())

    val state = combine(
        _state,
        _sortType,
        _expenses
    ) { state, sortType, expenses ->
        state.copy(
            expenses = expenses,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ExpenseState())

    fun onEvent(event: ExpenseEvent) {
        when (event) {
            is ExpenseEvent.DeleteExpense -> {
                viewModelScope.launch {
                    expenseRepository.deleteExpense(event.expense)
                }
            }

            ExpenseEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingExpense = false
                    )
                }
            }

            ExpenseEvent.SaveExpense -> {
                val description = state.value.description
                val value = state.value.value
                val date = state.value.date

                if (description.isBlank()) {
                    return
                }
                val expense = Expense(
                    description = description,
                    value = value,
                    date = date
                )
                viewModelScope.launch {
                    expenseRepository.upsertExpense(expense)
                }
                _state.update {
                    it.copy(
                        isAddingExpense = false,
                        description = "",
                        value = "",
                        date = ""
                    )
                }
            }

            is ExpenseEvent.SetDate -> {
                _state.update {
                    it.copy(
                        date = event.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    )
                }
            }

            is ExpenseEvent.SetDescription -> {
                _state.update {
                    it.copy(
                        description = event.description
                    )
                }
            }

            is ExpenseEvent.SetValue -> {
                _state.update {
                    it.copy(
                        value = event.value
                    )
                }
            }

            ExpenseEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        isAddingExpense = true
                    )
                }
            }

            is ExpenseEvent.SortExpenses -> {
                _sortType.value = event.sortType
            }
        }
    }

}
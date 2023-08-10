package com.dh.householdapp.domain.view.income

import com.dh.householdapp.domain.model.Income
import com.dh.householdapp.domain.sort.SortType
import java.time.LocalDate

sealed interface IncomeEvent {

    object SaveIncome : IncomeEvent
    data class SetDescription(val description: String) : IncomeEvent
    data class SetValue(val value: String) : IncomeEvent
    data class SetDate(val date: LocalDate) : IncomeEvent
    data class DeleteIncome(val income: Income) : IncomeEvent
    data class SortIncome(val sortType: SortType) : IncomeEvent
    object ShowDialog : IncomeEvent
    object HideDialog : IncomeEvent


}
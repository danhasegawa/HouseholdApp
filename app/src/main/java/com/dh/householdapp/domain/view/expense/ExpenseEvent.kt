package com.dh.householdapp.domain.view.expense

import com.dh.householdapp.domain.model.Expense
import com.dh.householdapp.domain.sort.SortType
import java.time.LocalDate

sealed interface ExpenseEvent {

    object SaveExpense : ExpenseEvent
    data class SetDescription(val description: String) : ExpenseEvent
    data class SetValue(val value: String) : ExpenseEvent
    data class SetDate(val date: LocalDate) : ExpenseEvent
    data class DeleteExpense(val expense: Expense) : ExpenseEvent
    data class SortExpenses(val sortType: SortType) : ExpenseEvent
    object ShowDialog : ExpenseEvent
    object HideDialog : ExpenseEvent

}
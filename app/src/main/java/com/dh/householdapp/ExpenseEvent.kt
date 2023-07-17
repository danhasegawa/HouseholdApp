package com.dh.householdapp

sealed interface ExpenseEvent {

    object SaveExpense : ExpenseEvent
    data class SetDescription(val description: String) : ExpenseEvent
    data class SetValue(val value: String) : ExpenseEvent
    data class SetDate(val date: String) : ExpenseEvent
    data class DeleteExpense(val expense: Expense) : ExpenseEvent
    data class SortExpenses(val sortType: SortType) : ExpenseEvent
    object ShowDialog : ExpenseEvent
    object HideDialog : ExpenseEvent



}
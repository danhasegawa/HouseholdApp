package com.dh.householdapp

import java.time.LocalDateTime

sealed interface ExpenseEvent {

    object SaveExpense : ExpenseEvent
    data class SetDescription(val description: String) : ExpenseEvent
    data class SetValue(val value: Double) : ExpenseEvent
    data class SetDate(val date: LocalDateTime) : ExpenseEvent
    data class DeleteExpense(val expense: Expense) : ExpenseEvent
    data class SortContacts(val sortType: SortType) : ExpenseEvent
    object ShowDialog : ExpenseEvent
    object HideDialog : ExpenseEvent



}
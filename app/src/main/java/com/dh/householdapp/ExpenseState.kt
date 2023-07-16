package com.dh.householdapp

import java.time.LocalDateTime

data class ExpenseState(
    val expenses: List<Expense> = emptyList(),
    val description: String = "",
    val value: Double = 0.0,
    val date: LocalDateTime = LocalDateTime.now(),
    val isAddingExpense: Boolean = false,
    val sortType: SortType = SortType.ALL
)
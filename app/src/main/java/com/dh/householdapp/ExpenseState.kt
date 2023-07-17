package com.dh.householdapp

data class ExpenseState(
    val expenses: List<Expense> = emptyList(),
    val description: String = "",
    val value: String = "",
    val date: String = "",//LocalDateTime.now().toString(),
    val isAddingExpense: Boolean = false,
    val sortType: SortType = SortType.ALL
)
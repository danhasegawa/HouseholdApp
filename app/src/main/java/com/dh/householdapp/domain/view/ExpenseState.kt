package com.dh.householdapp.domain.view

import com.dh.householdapp.domain.model.Expense
import com.dh.householdapp.domain.sort.SortType

data class ExpenseState(
    val expenses: List<Expense> = emptyList(),
    val description: String = "",
    val value: String = "",
    val date: String = "",
    val isAddingExpense: Boolean = false,
    val sortType: SortType = SortType.ALL
)
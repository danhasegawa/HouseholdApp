package com.dh.householdapp.domain.view.income

import com.dh.householdapp.domain.model.Income
import com.dh.householdapp.domain.sort.SortType

data class IncomeState(
    val incomes: List<Income> = emptyList(),
    val description: String = "",
    val value: String = "",
    val date: String = "",
    val isAddingIncome: Boolean = false,
    val sortType: SortType = SortType.ALL
)

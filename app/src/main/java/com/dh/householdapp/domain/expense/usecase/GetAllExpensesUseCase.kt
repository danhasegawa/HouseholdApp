package com.dh.householdapp.domain.expense.usecase

import com.dh.householdapp.domain.expense.model.Expense
import com.dh.householdapp.domain.expense.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllExpensesUseCase @Inject constructor(
    private val repository: ExpenseRepository
) {

    suspend operator fun invoke(): Flow<List<Expense>> {
        return repository.getAllExpenses()
    }
}
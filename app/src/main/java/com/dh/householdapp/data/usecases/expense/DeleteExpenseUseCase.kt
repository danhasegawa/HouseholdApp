package com.dh.householdapp.data.usecases.expense

import com.dh.householdapp.data.repository.ExpenseRepository
import com.dh.householdapp.domain.model.Expense
import javax.inject.Inject

class DeleteExpenseUseCase @Inject constructor(private val expenseRepository: ExpenseRepository) {
    
    suspend operator fun invoke(expense: Expense){
        expenseRepository.deleteExpense(expense)
    }
}
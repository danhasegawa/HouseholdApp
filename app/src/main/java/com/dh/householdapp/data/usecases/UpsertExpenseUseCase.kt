package com.dh.householdapp.data.usecases

import com.dh.householdapp.data.repository.ExpenseRepository
import com.dh.householdapp.domain.model.Expense
import javax.inject.Inject

class UpsertExpenseUseCase @Inject constructor(private val expenseRepository: ExpenseRepository){

    suspend operator fun invoke(expense: Expense){
        expenseRepository.upsertExpense(expense)
    }
}
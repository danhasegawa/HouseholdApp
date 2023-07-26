package com.dh.householdapp.data.usecases

import com.dh.householdapp.data.repository.ExpenseRepository
import com.dh.householdapp.domain.model.Expense
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllExpensesUseCase @Inject constructor(private val expenseRepository: ExpenseRepository) {

    operator fun invoke() : Flow<List<Expense>>{
        return expenseRepository.getAllExpense()
    }
}
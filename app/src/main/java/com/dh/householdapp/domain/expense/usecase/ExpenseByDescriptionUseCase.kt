package com.dh.householdapp.domain.expense.usecase

import com.dh.householdapp.domain.expense.repository.ExpenseRepository
import javax.inject.Inject

class ExpenseByDescriptionUseCase @Inject constructor(
    private val repository: ExpenseRepository
) {

    suspend operator fun invoke(description : String){
        repository.expenseByDescription(description)
    }
}
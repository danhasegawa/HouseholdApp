package com.dh.householdapp.data.usecases.income

import com.dh.householdapp.data.repository.IncomeRepository
import com.dh.householdapp.domain.model.Income
import javax.inject.Inject

class DeleteIncomeUseCase @Inject constructor(private val incomeRepository: IncomeRepository){

    suspend operator fun invoke(income: Income){
        incomeRepository.deleteIncome(income)
    }
}
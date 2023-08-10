package com.dh.householdapp.data.usecases.income

import com.dh.householdapp.data.repository.IncomeRepository
import com.dh.householdapp.domain.model.Income
import javax.inject.Inject

class UpsertIncomeUseCase @Inject constructor(private val incomeRepository: IncomeRepository) {

    suspend operator fun invoke(income: Income){
        incomeRepository.upsertIncome(income)
    }
}
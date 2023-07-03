package com.dh.householdapp.domain.income.usecase

import com.dh.householdapp.domain.income.repository.IncomeRepository
import javax.inject.Inject

class IncomeByDescriptionUseCase @Inject constructor(
    private val repository: IncomeRepository
) {

    suspend operator fun invoke(description: String) {
        repository.incomeByDescription(description)
    }
}
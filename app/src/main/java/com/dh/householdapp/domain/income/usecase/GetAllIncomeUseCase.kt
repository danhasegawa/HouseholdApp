package com.dh.householdapp.domain.income.usecase

import com.dh.householdapp.domain.income.model.Income
import com.dh.householdapp.domain.income.repository.IncomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllIncomeUseCase @Inject constructor(
    private val repository: IncomeRepository
) {

    suspend operator fun invoke(): Flow<List<Income>> {
        return repository.getAllIncome()
    }
}
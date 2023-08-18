package com.dh.householdapp.data.usecases.income

import com.dh.householdapp.data.repository.IncomeRepository
import com.dh.householdapp.domain.model.Income
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllIncomeByDateUseCase @Inject constructor(private val incomeRepository: IncomeRepository) {

    operator fun invoke(): Flow<List<Income>> {
        return incomeRepository.getIncomeByDate()
    }
}
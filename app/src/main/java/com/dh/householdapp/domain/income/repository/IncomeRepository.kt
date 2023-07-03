package com.dh.householdapp.domain.income.repository

import com.dh.householdapp.domain.income.model.Income
import kotlinx.coroutines.flow.Flow

interface IncomeRepository {

    suspend fun getAllIncome(): Flow<List<Income>>
    suspend fun incomeByDescription(description: String)
}
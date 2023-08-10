package com.dh.householdapp.data.source.income

import com.dh.householdapp.domain.model.Income
import kotlinx.coroutines.flow.Flow


interface  IncomeLocalDataSource {

    suspend fun upsertIncome(income: Income)
    suspend fun deleteIncome(income: Income)
    fun getAllIncome(): Flow<List<Income>>
    fun getIncomeByDescription(): Flow<List<Income>>
    fun getIncomeByValue(): Flow<List<Income>>
    fun getIncomeByDate(): Flow<List<Income>>


}
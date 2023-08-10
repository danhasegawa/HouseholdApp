package com.dh.householdapp.data.repository

import com.dh.householdapp.data.source.income.IncomeLocalDataSource
import com.dh.householdapp.domain.model.Income
import javax.inject.Inject

class IncomeRepository @Inject constructor(private val localDataSource: IncomeLocalDataSource) {

    suspend fun upsertIncome(income: Income) {
        localDataSource.upsertIncome(income)
    }

    suspend fun deleteIncome(income: Income) {
        localDataSource.deleteIncome(income)
    }

    fun getAllIncome() = localDataSource.getAllIncome()
    fun getIncomeByDescription() = localDataSource.getIncomeByDescription()
    fun getIncomeByValue() = localDataSource.getIncomeByValue()
    fun getIncomeByDate() = localDataSource.getIncomeByDate()
}
package com.dh.householdapp.data.repository

import com.dh.householdapp.data.source.income.IncomeLocalDataSource
import com.dh.householdapp.domain.model.Income

class IncomeRepository(private val localDataSource: IncomeLocalDataSource) {

    suspend fun upsertIncome(income: Income) {
        localDataSource.upsertIncome(income)
    }

    suspend fun deleteIncome(income: Income) {
        localDataSource.deleteIncome(income)
    }

    fun getAllIncome() = localDataSource.getAllIncomes()
    fun getIncomeByDescription() = localDataSource.getIncomeByDescription()
    fun getIncomeByValue() = localDataSource.getIncomeByValue()
    fun getIncomeByDate() = localDataSource.getIncomeByDate()
}
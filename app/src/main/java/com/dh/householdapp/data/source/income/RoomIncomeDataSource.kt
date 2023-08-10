package com.dh.householdapp.data.source.income

import com.dh.householdapp.data.dao.IncomeDao
import com.dh.householdapp.domain.model.Income
import kotlinx.coroutines.flow.Flow

class RoomIncomeDataSource(private val incomeDao: IncomeDao) : IncomeLocalDataSource {
    override suspend fun upsertIncome(income: Income) {
        return incomeDao.upsertIncome(income)
    }

    override suspend fun deleteIncome(income: Income) {
        return incomeDao.deleteIncome(income)
    }

    override fun getAllIncome(): Flow<List<Income>> {
        return incomeDao.getAllIncome()
    }

    override fun getIncomeByDescription(): Flow<List<Income>> {
        return incomeDao.getIncomeByDescription()
    }

    override fun getIncomeByValue(): Flow<List<Income>> {
        return incomeDao.getIncomeByValue()
    }

    override fun getIncomeByDate(): Flow<List<Income>> {
        return incomeDao.getIncomeByDate()
    }
}
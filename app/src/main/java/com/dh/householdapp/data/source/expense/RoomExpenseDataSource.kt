package com.dh.householdapp.data.source.expense

import com.dh.householdapp.data.dao.ExpenseDao
import com.dh.householdapp.domain.model.Expense
import kotlinx.coroutines.flow.Flow

class RoomExpenseDataSource(private val expenseDao: ExpenseDao) : ExpenseLocalDataSource {

    override suspend fun upsertExpense(expense: Expense) {
        return expenseDao.upsertExpense(expense)
    }

    override suspend fun deleteExpense(expense: Expense) {
        return expenseDao.deleteExpense(expense)
    }

    override fun getAllExpense(): Flow<List<Expense>> {
        return expenseDao.getAllExpense()
    }

    override fun getExpenseByDescription(): Flow<List<Expense>> {
        return expenseDao.getExpenseByDescription()
    }

    override fun getExpenseByValue(): Flow<List<Expense>> {
        return expenseDao.getExpenseByValue()
    }

    override fun getExpenseByDate(): Flow<List<Expense>> {
        return expenseDao.getExpenseByDate()
    }
}
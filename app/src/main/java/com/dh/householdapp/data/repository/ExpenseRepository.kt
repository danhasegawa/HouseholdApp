package com.dh.householdapp.data.repository

import com.dh.householdapp.data.dao.ExpenseDao
import com.dh.householdapp.domain.model.Expense
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val expenseDao: ExpenseDao) {

    suspend fun upsertExpense(expense: Expense) {
        expenseDao.upsertExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }

    fun getAllExpense() = expenseDao.getAllExpense()

    fun getExpenseByDescription() = expenseDao.getExpenseByDescription()

    fun getExpenseByValue() = expenseDao.getExpenseByValue()

    fun getExpenseByDate() = expenseDao.getExpenseByDate()


}
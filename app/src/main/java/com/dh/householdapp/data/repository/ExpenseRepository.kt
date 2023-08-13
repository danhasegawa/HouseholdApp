package com.dh.householdapp.data.repository

import com.dh.householdapp.data.source.expense.ExpenseLocalDataSource
import com.dh.householdapp.domain.model.Expense
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val localDataSource: ExpenseLocalDataSource) {

    suspend fun upsertExpense(expense: Expense) {
        localDataSource.upsertExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense) {
        localDataSource.deleteExpense(expense)
    }

    fun getAllExpense() = localDataSource.getAllExpense()

    fun getExpenseByDescription() = localDataSource.getExpenseByDescription()

    fun getExpenseByValue() = localDataSource.getExpenseByValue()

    fun getExpenseByDate() = localDataSource.getExpenseByDate()


}
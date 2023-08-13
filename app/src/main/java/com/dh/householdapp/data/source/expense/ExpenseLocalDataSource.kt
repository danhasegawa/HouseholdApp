package com.dh.householdapp.data.source.expense

import com.dh.householdapp.domain.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseLocalDataSource {

    suspend fun upsertExpense(expense: Expense)

    suspend fun deleteExpense(expense: Expense)

    fun getAllExpense(): Flow<List<Expense>>

    fun getExpenseByDescription(): Flow<List<Expense>>

    fun getExpenseByValue(): Flow<List<Expense>>

    fun getExpenseByDate(): Flow<List<Expense>>
}
package com.dh.householdapp.domain.expense.repository

import com.dh.householdapp.domain.expense.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {

    suspend fun getAllExpenses(): Flow<List<Expense>>
    suspend fun expenseByDescription(description : String)



}
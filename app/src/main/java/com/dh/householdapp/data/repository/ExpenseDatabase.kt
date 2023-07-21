package com.dh.householdapp.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dh.householdapp.data.dao.ExpenseDao
import com.dh.householdapp.domain.model.Expense

@Database(entities = [Expense::class], version = 1)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract val dao: ExpenseDao
}

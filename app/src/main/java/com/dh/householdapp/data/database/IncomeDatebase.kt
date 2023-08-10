package com.dh.householdapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dh.householdapp.data.dao.IncomeDao
import com.dh.householdapp.domain.model.Income

@Database(entities = [Income::class], version = 1)

abstract class IncomeDatebase : RoomDatabase() {

    abstract val incomeDao: IncomeDao
}
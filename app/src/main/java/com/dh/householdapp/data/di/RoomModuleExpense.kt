package com.dh.householdapp.data.di

import android.content.Context
import androidx.room.Room
import com.dh.householdapp.data.dao.ExpenseDao
import com.dh.householdapp.data.database.ExpenseDatabase
import com.dh.householdapp.data.source.expense.ExpenseLocalDataSource
import com.dh.householdapp.data.source.expense.RoomExpenseDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideExpenseDatabase(@ApplicationContext context: Context): ExpenseDatabase {
        return Room.databaseBuilder(
            context,
            ExpenseDatabase::class.java,
            "expenses.db"
        ).build()
    }

    @Provides
    fun provideExpenseDao(expenseDatabase: ExpenseDatabase): ExpenseDao {
        return expenseDatabase.dao
    }

    @Provides
    fun provideLocalExpenseDataSource(expenseDao: ExpenseDao): ExpenseLocalDataSource {
        return RoomExpenseDataSource(expenseDao)
    }


}


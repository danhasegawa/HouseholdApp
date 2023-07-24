package com.dh.householdapp.data.di

import android.content.Context
import androidx.room.Room
import com.dh.householdapp.data.dao.ExpenseDao
import com.dh.householdapp.data.repository.ExpenseDatabase
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
}


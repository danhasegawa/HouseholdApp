package com.dh.householdapp.data.di

import android.content.Context
import androidx.room.Room
import com.dh.householdapp.data.dao.IncomeDao
import com.dh.householdapp.data.database.IncomeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomIncomeModule {

    @Provides
    fun provideIncomeDatabase(@ApplicationContext context: Context): IncomeDatabase {
        return Room.databaseBuilder(
            context,
            IncomeDatabase::class.java,
            "income.db"
        ).build()
    }

    @Provides
    fun provideIncomeDao(incomeDatabase: IncomeDatabase): IncomeDao {
        return incomeDatabase.daoIncome
    }

//    @Provides
//    fun provideLocalIncomeDataSource(incomeDao: IncomeDao): IncomeLocalDataSource {
//        return RoomIncomeDataSource(incomeDao)
//    }


}


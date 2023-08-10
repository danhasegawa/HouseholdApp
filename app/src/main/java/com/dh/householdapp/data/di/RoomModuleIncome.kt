package com.dh.householdapp.data.di

import android.content.Context
import androidx.room.Room
import com.dh.householdapp.data.dao.IncomeDao
import com.dh.householdapp.data.database.IncomeDatebase
import com.dh.householdapp.data.source.income.IncomeLocalDataSource
import com.dh.householdapp.data.source.income.RoomIncomeDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModuleIncome {

    @Provides
    fun provideIncomeDatabase(@ApplicationContext context: Context): IncomeDatebase {
        return Room.databaseBuilder(
            context,
            IncomeDatebase::class.java,
            "income.db"
        ).build()
    }

    @Provides
    fun provideIncomeDao(incomeDatebase: IncomeDatebase):IncomeDao{
        return incomeDatebase.incomeDao
    }

    @Provides
    fun provideLocalIncomeDataSource(incomeDao: IncomeDao):IncomeLocalDataSource{
        return RoomIncomeDataSource(incomeDao)
    }
}
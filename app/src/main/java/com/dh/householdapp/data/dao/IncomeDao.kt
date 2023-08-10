package com.dh.householdapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.dh.householdapp.domain.model.Income
import kotlinx.coroutines.flow.Flow

@Dao
interface IncomeDao {

    @Upsert
    suspend fun upsertIncome(income: Income)

    @Delete
    suspend fun deleteIncome(income: Income)

    @Query("SELECT * FROM income")
    fun getAllIncome(): Flow<List<Income>>

    @Query("SELECT * FROM income ORDER BY description ASC")
    fun getIncomeByDescription(): Flow<List<Income>>

    @Query("SELECT * FROM income ORDER BY value ASC")
    fun getIncomeByValue(): Flow<List<Income>>

    @Query("SELECT * FROM income ORDER BY date ASC")
    fun getIncomeByDate(): Flow<List<Income>>
}
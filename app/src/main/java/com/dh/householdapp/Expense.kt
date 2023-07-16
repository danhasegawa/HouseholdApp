package com.dh.householdapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

typealias ExpenseDomain = Expense

@Entity
data class Expense(
    val description: String,
    val value: Double,
    val date: LocalDateTime,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)

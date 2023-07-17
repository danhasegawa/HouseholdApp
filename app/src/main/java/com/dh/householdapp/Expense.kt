package com.dh.householdapp

import androidx.room.Entity
import androidx.room.PrimaryKey

typealias ExpenseDomain = Expense

@Entity
data class Expense(
    val description: String,
    val value: String,
    val date: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)

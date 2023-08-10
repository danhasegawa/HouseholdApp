package com.dh.householdapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Income(
    val description: String,
    val value: String,
    val date: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
) {
}
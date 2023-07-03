package com.dh.householdapp.domain.expense.model

import java.math.BigDecimal
import java.time.LocalDateTime

typealias ExpenseDomain = Expense

data class Expense(
    val id: Long,
    val description: String,
    val value: BigDecimal,
    val date: LocalDateTime
)

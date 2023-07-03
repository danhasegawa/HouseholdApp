package com.dh.householdapp.domain.income.model

import java.math.BigDecimal
import java.time.LocalDateTime

typealias IncomeDomain = Income

data class Income(
    val id: Long,
    val description: String,
    val value: BigDecimal,
    val date: LocalDateTime
)
package com.example.santanderdevweek.data

data class Account(
    val number: String,
    val agency: String,
    val balance: String,
    val limite: String,
    val client: Client,
    val card: Card
)
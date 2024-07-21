package com.example.haddamanagementconsole.DataLayer.Models

data class AllOrderItem(
    val address: Double,
    val category: String,
    val email: String,
    val id: Int,
    val name: String,
    val orderDate: String,
    val orderTiming: Double,
    val phone_no: String,
    val price: Int,
    val user_id: String
)
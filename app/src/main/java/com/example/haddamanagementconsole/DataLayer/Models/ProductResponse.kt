package com.example.haddamanagementconsole.DataLayer.Models

data class ProductResponse(
    var Unit: Int,
    val category: String,
    val id: Int,
    var price: Double,
    val status: String
)
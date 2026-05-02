package com.example.rigbuilder.data

data class PCPart(
    val id: Int,
    val name: String,
    val category: String,
    val brand: String,
    val price: Double,
    val specs: String,
    val socket: String = ""
)
package com.example.coremodel.entities

import java.util.Date

data class Product(
    val productId: Long = 0L,
    val categoryID: Long,
    val title: String,
    val comment: String,
    val rating: Int,
    val photoURI: String? = null,
    val barcode: String? = null,
    val price: String? = null,
    val createdAt: Date
)
fun emptyProduct():Product = Product(
    productId = 0L,
    categoryID = 0L,
    title = "",
    comment = "",
    rating = 0,
    photoURI = "",
    barcode = "",
    price = "",
    createdAt = Date(0)
)
package com.example.topcart.core.entities

data class Product(
    val id: Long,
    val category: ProductCategory,
    val title: String,
    val comment: String,
    val rating: Int,
    val photoURI: String? = null,
    val barcode: Long? = null,
    val price: Float? = null,
)
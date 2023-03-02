package com.example.topcart.core.entities

data class ProductCategory(
    val id: Long,
    val title: String,
    val parentId: Long = 0,
)
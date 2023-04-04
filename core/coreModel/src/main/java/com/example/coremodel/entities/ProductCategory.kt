package com.example.coremodel.entities

import java.util.Date

data class ProductCategory(
    val categoryId: Long = 0L,
    val categoryTitle: String,
    val parentCategoryId: Long = 0,
    val createdAt: Date
)
fun emptyCategory():ProductCategory = ProductCategory(
    categoryId = 0L,
    categoryTitle = "",
    parentCategoryId = 0L,
    createdAt = Date()
)

//TODO убрать тестовый список категорий
val testCategories = listOf(
    ProductCategory(categoryId = 0L, "Все", createdAt = Date()),
    ProductCategory(categoryId = 10001L, "Кино", createdAt = Date()),
    ProductCategory(categoryId = 10002L, "Жижа", createdAt = Date()),
    ProductCategory(categoryId = 10003L, "Чай", createdAt = Date()),
    ProductCategory(categoryId = 10004L, "Зубник", createdAt = Date()),
    ProductCategory(categoryId = 10005L, "Алкоголь", createdAt = Date()),
)
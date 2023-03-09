package com.example.coremodel.entities

import java.util.Date

data class ProductCategory(
    val categoryId: Long,
    val categoryTitle: String,
    val parentCategoryId: Long = 0,
    val createdAt: Date? = null
)

//TODO убрать тестовый список категорий
val testCategories = listOf(
    ProductCategory(categoryId = 0L, "Все"),
    ProductCategory(categoryId = 10001L, "Кино"),
    ProductCategory(categoryId = 10002L, "Жижа"),
    ProductCategory(categoryId = 10003L, "Чай"),
    ProductCategory(categoryId = 10004L, "Зубник"),
    ProductCategory(categoryId = 10005L, "Алкоголь"),
)
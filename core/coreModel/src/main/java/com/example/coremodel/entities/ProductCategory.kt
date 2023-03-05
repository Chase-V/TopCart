package com.example.coremodel.entities

data class ProductCategory(
    val id: Long,
    val title: String,
    val parentId: Long = 0,
)

//TODO убрать тестовый список категорий
val testCategories = listOf(
    ProductCategory(id = 0L, "Все"),
    ProductCategory(id = 10001L, "Кино"),
    ProductCategory(id = 10002L, "Жижа"),
    ProductCategory(id = 10003L, "Чай"),
    ProductCategory(id = 10004L, "Зубник"),
    ProductCategory(id = 10005L, "Алкоголь"),
)
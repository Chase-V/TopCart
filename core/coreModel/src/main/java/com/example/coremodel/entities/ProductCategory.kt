package com.example.coremodel.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_category_table")
data class ProductCategory(
    @PrimaryKey(autoGenerate = true) val categoryId: Long,
    val categoryTitle: String,
    val parentCategoryId: Long = 0,
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
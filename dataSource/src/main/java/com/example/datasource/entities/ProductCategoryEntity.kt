package com.example.datasource.entities

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.coremodel.entities.ProductCategory
import com.example.datasource.utils.DateConverter
import java.util.Date

@TypeConverters(DateConverter::class)
@Entity(tableName = "product_category_table")
data class ProductCategoryEntity(
    @PrimaryKey(autoGenerate = true) val categoryId: Long,
    val categoryTitle: String,
    val parentCategoryId: Long = 0,
    val createdAt: Date
) {

    fun toProductCategory(): ProductCategory {
        return ProductCategory(
            categoryId = categoryId,
            categoryTitle = categoryTitle,
            parentCategoryId = parentCategoryId,
            createdAt = createdAt
        )
    }
}
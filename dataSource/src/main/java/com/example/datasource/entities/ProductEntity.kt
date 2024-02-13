package com.example.datasource.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import com.example.datasource.utils.DateConverter
import java.util.Date

@TypeConverters(DateConverter::class)
@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val productId: Long,
    val categoryID: Long,
    val title: String,
    val comment: String,
    val rating: Int,
    val photoURI: String? = null,
    val barcode: String? = null,
    val price: String? = null,
    val createdAt: Date
) {
    fun toProduct(): Product {
        return Product(
            productId = productId,
            categoryID = categoryID,
            title = title,
            comment = comment,
            rating = rating,
            photoURI = photoURI,
            barcode = barcode,
            price = price,
            createdAt = createdAt
        )
    }
}
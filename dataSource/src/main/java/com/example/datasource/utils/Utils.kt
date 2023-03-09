package com.example.datasource.utils

import androidx.room.TypeConverter
import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import com.example.datasource.entities.ProductCategoryEntity
import com.example.datasource.entities.ProductEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateConverter {
    private val df = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    @TypeConverter
    fun toDate(date: String): Date {
        return df.parse(date)
    }

    @TypeConverter
    fun toDateString(date: Date): String {
        return df.format(date)
    }
}

fun Flow<List<ProductEntity>>.toProductsList():Flow<List<Product>>{
    return this.map { list ->
        list.map {productEntity ->
            productEntity.toProduct()
        }
    }
}
fun Flow<List<ProductCategoryEntity>>.toProductCategoryList():Flow<List<ProductCategory>>{
    return this.map { list ->
        list.map {productCategoryEntity ->
            productCategoryEntity.toProductCategory()
        }
    }
}

fun Product.toEntity(createdAt:Date):ProductEntity{
    return ProductEntity(
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

fun ProductCategory.toEntity(createdAt: Date):ProductCategoryEntity{
    return ProductCategoryEntity(
        categoryId = categoryId,
        categoryTitle = categoryTitle,
        parentCategoryId = parentCategoryId,
        createdAt = createdAt
    )
}

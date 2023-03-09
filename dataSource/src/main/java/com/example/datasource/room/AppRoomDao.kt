package com.example.datasource.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.datasource.entities.ProductCategoryEntity
import com.example.datasource.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product_category_table")
    fun getAllCategories(): Flow<List<ProductCategoryEntity>>

    @Query("SELECT * FROM product_table WHERE productId == :id")
    fun getProduct(id: Long): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product_category_table WHERE categoryId == :id")
    fun getCategory(id: Long): Flow<List<ProductCategoryEntity>>

    @Query("SELECT * FROM product_table WHERE categoryID == :categoryId")
    fun getProductsFromCategory(categoryId: Long): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product_category_table WHERE parentCategoryId == :categoryId")
    fun getSubCategories(categoryId: Long): Flow<List<ProductCategoryEntity>>

    @Insert
    suspend fun createProduct(product: ProductEntity)

    @Insert
    suspend fun createProductCategory(category: ProductCategoryEntity)

    @Delete
    suspend fun deleteProduct(product: ProductEntity)

    @Delete
    suspend fun deleteProductCategory(category: ProductCategoryEntity)

    @Update
    suspend fun updateProduct(product: ProductEntity)

    @Update
    suspend fun updateProductCategory(category: ProductCategoryEntity)

}
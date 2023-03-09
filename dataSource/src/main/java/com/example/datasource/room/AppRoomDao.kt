package com.example.datasource.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product_category_table")
    fun getAllCategories(): Flow<List<ProductCategory>>

    @Query("SELECT * FROM product_table WHERE productId == :id")
    fun getProduct(id: Long): Flow<List<Product>>

    @Query("SELECT * FROM product_category_table WHERE categoryId == :id")
    fun getCategory(id: Long): Flow<List<ProductCategory>>

    @Query("SELECT * FROM product_table WHERE categoryID == :categoryId")
    fun getProductsFromCategory(categoryId: Long) :Flow<List<Product>>

    @Query("SELECT * FROM product_category_table WHERE parentCategoryId == :categoryId")
    fun getSubCategories(categoryId: Long) : Flow<List<ProductCategory>>

    @Insert(entity = Product::class)
    suspend fun createProduct(product: Product, onSuccess: () -> Unit)

    @Insert(entity = ProductCategory::class)
    suspend fun createProductCategory(category: ProductCategory, onSuccess: () -> Unit)

    @Delete(entity = Product::class)
    suspend fun deleteProduct(product: Product, onSuccess: () -> Unit)

    @Delete(entity = ProductCategory::class)
    suspend fun deleteProductCategory(category: ProductCategory, onSuccess: () -> Unit)

    @Update(entity = Product::class)
    suspend fun updateProduct(product: Product, onSuccess: () -> Unit)

    @Update(entity = ProductCategory::class)
    suspend fun updateProductCategory(category: ProductCategory, onSuccess: () -> Unit)

}
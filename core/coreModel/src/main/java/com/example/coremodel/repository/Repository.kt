package com.example.coremodel.repository

import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface Repository {

    suspend fun getAllProducts(): Flow<List<Product>>
    suspend fun getAllCategories(): Flow<List<ProductCategory>>

//    suspend fun getProduct(id:Long): Flow<List<Product>>
//    suspend fun getCategory(id:Long): Flow<List<ProductCategory>>

    suspend fun getSubProductsFromCategory(categoryId: Long): Flow<List<Product>>
    suspend fun getSubCategories(categoryId: Long): Flow<List<ProductCategory>>


    suspend fun createProduct(product: Product, createdAt: Date, onSuccess: () -> Unit)
    suspend fun createProductCategory(
        category: ProductCategory,
        createdAt: Date,
        onSuccess: () -> Unit
    )

    suspend fun deleteProduct(product: Product, createdAt: Date, onSuccess: () -> Unit)
    suspend fun deleteProductCategory(
        category: ProductCategory,
        createdAt: Date,
        onSuccess: () -> Unit
    )

    suspend fun updateProduct(product: Product, createdAt: Date, onSuccess: () -> Unit)
    suspend fun updateProductCategory(
        category: ProductCategory,
        createdAt: Date,
        onSuccess: () -> Unit
    )


//    {
//       Product -> Room -> if(Firebase) ->firebase else null
//    }
//    TODO убрать комменты
//    {
//        -> suspend Room -> suspend  Firebase -> onSuccessFB -> update Room
//
//
//        -> Room -> ?room=?fb -> fb
//
//        -> ?room&fb -> == -> Room
//    }
//    {
//        -> Room -> FB
//    }

}
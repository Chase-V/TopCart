package com.example.coremodel.repository

import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllProducts(): Flow<List<Product>>
    fun getAllCategories(): Flow<List<ProductCategory>>

    fun getProduct(id:Long): Flow<List<Product>>
    fun getCategory(id:Long): Flow<List<ProductCategory>>

    fun getSubProductsFromCategory(categoryId:Long): Flow<List<Product>>
    fun getSubCategories(categoryId:Long): Flow<List<ProductCategory>>

//    TODO убрать комменты
//    {
//        -> suspend Room -> suspend  Firebase -> onSuccessFB -> update Room
//
//
//        -> Room -> ?room=?fb -> fb
//
//        -> ?room&fb -> == -> Room
//    }

    suspend fun createProduct(product: Product, onSuccess:()->Unit)
    suspend fun createProductCategory(category: ProductCategory, onSuccess:()->Unit)
//    {
//       Product -> Room -> if(Firebase) ->firebase else null
//    }

    suspend fun deleteProduct(product: Product, onSuccess:()->Unit)
    suspend fun deleteProductCategory(category: ProductCategory, onSuccess:()->Unit)


    suspend fun updateProduct(product: Product, onSuccess:()->Unit)
    suspend fun updateProductCategory(category: ProductCategory, onSuccess:()->Unit)

//    {
//        -> Room -> FB
//    }

}
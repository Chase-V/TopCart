package com.example.coremodel.repository

import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface Repository {

     fun getAllProducts(): Flow<List<Product>>
     fun getAllCategories(): Flow<List<ProductCategory>>

     fun getProduct(id:Long): Flow<Product>
     fun getCategory(id:Long): Flow<ProductCategory>

     fun getSubProductsFromCategory(categoryId: Long): Flow<List<Product>>
     fun getSubCategories(categoryId: Long): Flow<List<ProductCategory>>


    suspend fun createProduct(product: Product, onSuccess: () -> Unit)
    suspend fun createProductCategory(
        category: ProductCategory,
        onSuccess: () -> Unit
    )

    suspend fun deleteProduct(product: Product, onSuccess: () -> Unit)
    suspend fun deleteProductCategory(
        category: ProductCategory,
        onSuccess: () -> Unit
    )

    suspend fun updateProduct(product: Product, onSuccess: () -> Unit)
    suspend fun updateProductCategory(
        category: ProductCategory,
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
package com.example.datasource.repoImpl

import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import com.example.coremodel.repository.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl : Repository {
    override fun getAllProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override fun getAllCategories(): Flow<List<ProductCategory>> {
        TODO("Not yet implemented")
    }

    override fun getProduct(id: Long): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override fun getCategory(id: Long): Flow<List<ProductCategory>> {
        TODO("Not yet implemented")
    }

    override fun getSubProductsFromCategory(categoryId: Long) {
        TODO("Not yet implemented")
    }

    override fun getSubCategories(categoryId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun createProduct(product: Product, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun createProductCategory(category: ProductCategory, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(product: Product, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProductCategory(category: ProductCategory, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(product: Product, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun updateProductCategory(category: ProductCategory, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }


}
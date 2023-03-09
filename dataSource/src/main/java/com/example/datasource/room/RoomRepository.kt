package com.example.datasource.room

import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import com.example.coremodel.repository.Repository
import kotlinx.coroutines.flow.Flow

class RoomRepository(private val appRoomDao:AppRoomDao) :Repository {
    override fun getAllProducts(): Flow<List<Product>> {
        return appRoomDao.getAllProducts()
    }

    override fun getAllCategories(): Flow<List<ProductCategory>> {
        return appRoomDao.getAllCategories()
    }

    override fun getProduct(id: Long): Flow<List<Product>> {
        return appRoomDao.getProduct(id)
    }

    override fun getCategory(id: Long): Flow<List<ProductCategory>> {
        return appRoomDao.getCategory(id)
    }

    override fun getSubProductsFromCategory(categoryId: Long) : Flow<List<Product>>{
        return appRoomDao.getProductsFromCategory(categoryId)
    }

    override fun getSubCategories(categoryId: Long): Flow<List<ProductCategory>>  {
        return appRoomDao.getSubCategories(categoryId)
    }

    override suspend fun createProduct(product: Product, onSuccess: () -> Unit) {
        return appRoomDao.createProduct(product, { TODO() })
    }

    override suspend fun createProductCategory(category: ProductCategory, onSuccess: () -> Unit) {
        return appRoomDao.createProductCategory(category, {TODO()})
    }

    override suspend fun deleteProduct(product: Product, onSuccess: () -> Unit) {
        return appRoomDao.deleteProduct(product, {TODO()})
    }

    override suspend fun deleteProductCategory(category: ProductCategory, onSuccess: () -> Unit) {
        return appRoomDao.createProductCategory(category, {TODO()})
    }

    override suspend fun updateProduct(product: Product, onSuccess: () -> Unit) {
        return appRoomDao.updateProduct(product, {TODO()})
    }

    override suspend fun updateProductCategory(category: ProductCategory, onSuccess: () -> Unit) {
        return appRoomDao.updateProductCategory(category, {TODO()})
    }
}
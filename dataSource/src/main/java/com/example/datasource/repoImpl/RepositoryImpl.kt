package com.example.datasource.repoImpl

import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import com.example.coremodel.repository.Repository
import com.example.datasource.room.AppRoomDao
import com.example.datasource.utils.toEntity
import com.example.datasource.utils.toProductCategoryList
import com.example.datasource.utils.toProductsList
import kotlinx.coroutines.flow.Flow
import java.util.Date

class RepositoryImpl(private val appRoomDao: AppRoomDao) : Repository {

    override suspend fun getAllProducts(): Flow<List<Product>> {

        return appRoomDao.getAllProducts().toProductsList()
    }

    override suspend fun getAllCategories(): Flow<List<ProductCategory>> {
        return appRoomDao.getAllCategories().toProductCategoryList()
    }


    override suspend fun getSubProductsFromCategory(categoryId: Long): Flow<List<Product>> {
        return appRoomDao.getProductsFromCategory(categoryId).toProductsList()
    }

    override suspend fun getSubCategories(categoryId: Long): Flow<List<ProductCategory>> {
        return appRoomDao.getSubCategories(categoryId).toProductCategoryList()
    }

    override suspend fun createProduct(product: Product, createdAt: Date, onSuccess: () -> Unit) {
        return appRoomDao.createProduct(product = product.toEntity(createdAt))
    }

    override suspend fun createProductCategory(
        category: ProductCategory,
        createdAt: Date,
        onSuccess: () -> Unit
    ) {
        return appRoomDao.createProductCategory(category = category.toEntity(createdAt))
    }

    override suspend fun deleteProduct(product: Product, createdAt: Date, onSuccess: () -> Unit) {
        return appRoomDao.deleteProduct(product = product.toEntity(createdAt))
    }

    override suspend fun deleteProductCategory(
        category: ProductCategory,
        createdAt: Date,
        onSuccess: () -> Unit
    ) {
        return appRoomDao.deleteProductCategory(category = category.toEntity(createdAt))
    }

    override suspend fun updateProduct(product: Product, createdAt: Date, onSuccess: () -> Unit) {
        return appRoomDao.updateProduct(product = product.toEntity(createdAt))
    }

    override suspend fun updateProductCategory(
        category: ProductCategory,
        createdAt: Date,
        onSuccess: () -> Unit
    ) {
        return appRoomDao.updateProductCategory(category = category.toEntity(createdAt))
    }


}
//    override suspend fun getProduct(id: Long): Flow<List<Product>> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun getCategory(id: Long): Flow<List<ProductCategory>> {
//        TODO("Not yet implemented")
//    }

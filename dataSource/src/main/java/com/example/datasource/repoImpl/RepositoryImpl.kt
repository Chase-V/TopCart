package com.example.datasource.repoImpl

import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import com.example.coremodel.repository.Repository
import com.example.datasource.room.AppRoomDao
import com.example.datasource.utils.toEntity
import com.example.datasource.utils.toProduct
import com.example.datasource.utils.toProductCategory
import com.example.datasource.utils.toProductCategoryList
import com.example.datasource.utils.toProductsList
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val appRoomDao: AppRoomDao) : Repository {

    override fun getAllProducts(): Flow<List<Product>> =
        appRoomDao.getAllProducts().toProductsList()


    override fun getAllCategories(): Flow<List<ProductCategory>> =
        appRoomDao.getAllCategories().toProductCategoryList()


    override fun getProduct(id: Long): Flow<Product> =
        appRoomDao.getProduct(id = id).toProduct()

    override fun getCategory(id: Long): Flow<ProductCategory> =
        appRoomDao.getCategory(id).toProductCategory()

    override fun getSubProductsFromCategory(categoryId: Long): Flow<List<Product>> =
        appRoomDao.getProductsFromCategory(categoryId).toProductsList()


    override fun getSubCategories(categoryId: Long): Flow<List<ProductCategory>> =
        appRoomDao.getSubCategories(categoryId).toProductCategoryList()


    override suspend fun createProduct(product: Product, onSuccess: () -> Unit) =
        appRoomDao.createProduct(product = product.toEntity())


    override suspend fun createProductCategory(
        category: ProductCategory, onSuccess: () -> Unit
    ) = appRoomDao.createProductCategory(category = category.toEntity())


    override suspend fun deleteProduct(product: Product, onSuccess: () -> Unit) =
        appRoomDao.deleteProduct(product = product.toEntity())


    override suspend fun deleteProductCategory(category: ProductCategory, onSuccess: () -> Unit) =
        appRoomDao.deleteProductCategory(category = category.toEntity())


    override suspend fun updateProduct(product: Product, onSuccess: () -> Unit) =
        appRoomDao.updateProduct(product = product.toEntity())


    override suspend fun updateProductCategory(
        category: ProductCategory,
        onSuccess: () -> Unit
    ) = appRoomDao.updateProductCategory(category = category.toEntity())


}


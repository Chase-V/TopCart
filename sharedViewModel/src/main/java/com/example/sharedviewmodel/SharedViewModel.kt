package com.example.sharedviewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import com.example.coremodel.entities.emptyCategory
import com.example.coremodel.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SharedViewModel(private val repo: Repository) :
    AndroidViewModel(application = Application()) {

    val getAllProducts: Flow<List<Product>> = repo.getAllProducts()

    val getAllCategories: Flow<List<ProductCategory>> = repo.getAllCategories()

    fun getCategory(categoryID: Long): Flow<ProductCategory> {
        return repo.getCategory(categoryID)
    }

    private val _suggestedCategories = MutableStateFlow<List<ProductCategory>>(emptyList())
    val suggestedCategories: StateFlow<List<ProductCategory>>
        get() = _suggestedCategories

    private val _suggestedProducts = MutableStateFlow<List<Product>>(emptyList())
    val suggestedProducts: StateFlow<List<Product>>
        get() = _suggestedProducts

    private val backStack:MutableList<ProductCategory> = mutableListOf()

    init {
        resetSuggestions()
    }

    fun resetSuggestions(){
        viewModelScope.launch {
            getAllProducts.collect {
                _suggestedProducts.value = it
                Log.d("MyLog", "init: $it")
            }
        }
        viewModelScope.launch {
            getAllCategories.collect {
                Log.d("MyLog", "init2: $it")
                _suggestedCategories.value = it
            }
        }
    }

    fun returnBack(){
        backStack.removeLastOrNull()
        if (backStack.isNullOrEmpty()) resetSuggestions()
        else categoriesChanged(backStack.last(), isAddToBackstack = false)
    }


    fun categoriesChanged(category: ProductCategory, isAddToBackstack:Boolean = true) {

        if (isAddToBackstack) backStack.add(category)

        viewModelScope.launch {

            getAllCategories.collect { list ->
                val newCategories = list.filter { item ->
                    item.parentCategoryId == category.categoryId
                }
                _suggestedCategories.value = newCategories
                Log.d("MyLog", "categoriesChangedCats: $newCategories")
            }
        }
        viewModelScope.launch {
            getAllProducts.collect { list ->
                val newProducts = list.filter { item ->
                    item.categoryID == category.categoryId
                }
                _suggestedProducts.value = newProducts
                Log.d("MyLog", "categoriesChangedProds: $newProducts")
            }
        }
    }

    fun getProduct(productId: Long): Flow<Product> {
        return repo.getProduct(productId)
    }

    fun updateProduct(product: Product) {
        viewModelScope.launch {
            repo.updateProduct(product) {}
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            repo.deleteProduct(product) {}
        }
    }

    fun addProduct(product: Product, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.createProduct(product, onSuccess = onSuccess)
        }
    }

    fun addCategory(category: ProductCategory, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.createProductCategory(category) {}
        }
    }

    fun deleteCategory(category: ProductCategory) {
        viewModelScope.launch {
            repo.deleteProductCategory(category) {}
        }
    }

    class SharedViewModelFactory(private val repo: Repository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == SharedViewModel::class.java)
            return SharedViewModel(repo = repo) as T
        }
    }
}

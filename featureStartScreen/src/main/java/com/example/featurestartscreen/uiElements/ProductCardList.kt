package com.example.featurestartscreen.uiElements

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.coremodel.entities.Product
import com.example.sharedviewmodel.SharedViewModel

@Composable
fun ProductList(
    products: List<Product>,
    navController: NavController,
    viewModel: SharedViewModel
) {
    LazyColumn {
        items(products) { item ->
            ProductCard(
                product = item,
                onCardClick = {
                    Log.d("MyLog", "ProductList: $item")
                    navController.navigate("editProduct_screen/${item.productId}")
                },
                onCardLongClick = {
                    viewModel.deleteProduct(item)
                }
            )
        }
    }
}
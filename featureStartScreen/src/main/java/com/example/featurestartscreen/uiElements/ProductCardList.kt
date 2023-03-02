package com.example.featurestartscreen.uiElements

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.topcart.core.entities.Product

@Composable
fun ProductList(
    products: List<Product>
) {
    LazyColumn {
        items(products) { item ->
            ProductCard(product = item)
        }
    }
}
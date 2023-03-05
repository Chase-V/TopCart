package com.example.topcart.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

//Todo конь не валялся, просто заглушка

@Composable
fun AppNavigationBar(
    onNavigateToHome: () -> Unit,
    onNavigateToSearch:()->Unit,
    onNavigateToAddProduct:() -> Unit,
    onNavigateToCart:()->Unit
) {
    NavigationBar() {
        NavigationBarItem(
            selected = true,
            onClick = onNavigateToHome,
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null
                )
            })
        NavigationBarItem(
            selected = false,
            onClick = onNavigateToSearch,
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            })
        NavigationBarItem(
            selected = false,
            onClick = onNavigateToAddProduct,
            icon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            })
        NavigationBarItem(
            selected = false,
            onClick = onNavigateToCart,
            icon = {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = null
                )
            })
    }
}
package com.example.topcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.topcart.navigation.AppNavHost
import com.example.topcart.navigation.AppNavRoute
import com.example.topcart.navigation.AppNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppNavigationBar(
                            onNavigateToHome = { navController.navigate(AppNavRoute.MainScreen.route) },
                            onNavigateToSearch = {},
                            onNavigateToAddProduct = {navController.navigate(AppNavRoute.AddProductScreen.route)},
                            onNavigateToCart = {}
                        )
                    }
                ) { paddingValues ->
                    Surface(modifier = Modifier.padding(paddingValues)) {
                        AppNavHost(navController = navController)
                    }
                }
            }
        }
    }
}
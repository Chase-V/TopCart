package com.example.topcart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.featurestartscreen.MainScreenUI

sealed class AppNavRoute(val route: String) {
    object MainScreen : AppNavRoute("main_screen")
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppNavRoute.MainScreen.route) {
        composable(AppNavRoute.MainScreen.route) { MainScreenUI(navController = navController) }
    }
}
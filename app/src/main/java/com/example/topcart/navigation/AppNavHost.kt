package com.example.topcart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.featureaddproduct.AddProductScreenUI
import com.example.featurestartscreen.MainScreenUI

sealed class AppNavRoute(val route: String) {
    object MainScreen : AppNavRoute("main_screen")
    object AddProductScreen : AppNavRoute("addProduct_screen")
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    startDestination:String = AppNavRoute.MainScreen.route
) {


    NavHost(navController = navController, startDestination = startDestination) {
        composable(AppNavRoute.MainScreen.route) { MainScreenUI(navController = navController) }
        composable(AppNavRoute.AddProductScreen.route) { AddProductScreenUI(navController = navController) }
    }
}
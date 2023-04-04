package com.example.topcart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.featureaddproduct.AddCategoryScreenUI
import com.example.featureaddproduct.AddProductScreenUI
import com.example.featureaddproduct.EditProductScreenUI
import com.example.featurestartscreen.MainScreenUI

sealed class AppNavRoute(val route: String) {
    object MainScreen : AppNavRoute("main_screen")
    object AddProductScreen : AppNavRoute("addProduct_screen")
    object AddCategoryScreen: AppNavRoute("addCategory_screen")
    object EditProductScreen : AppNavRoute("editProduct_screen")
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    startDestination: String = AppNavRoute.MainScreen.route
) {


    NavHost(navController = navController, startDestination = startDestination) {
        composable(AppNavRoute.MainScreen.route) {
            MainScreenUI(navController = navController)
        }
        composable(route = AppNavRoute.AddProductScreen.route) {
            AddProductScreenUI(navController = navController, onSuccessfullyAdded = {
                navController.navigate(AppNavRoute.MainScreen.route)
            })
        }

        composable(route = AppNavRoute.AddCategoryScreen.route){
            AddCategoryScreenUI(navController = navController)
        }

        composable(AppNavRoute.EditProductScreen.route + "/{$PRODUCT_ID}",
            arguments = listOf(
                navArgument("$PRODUCT_ID") {
                    defaultValue = 0L
                    type = NavType.LongType
                }
            )) { navBackStackEntry ->
            val productId = navBackStackEntry.arguments?.getLong(PRODUCT_ID)
            productId?.let { EditProductScreenUI(productId = it, navController = navController) }

        }
    }
}
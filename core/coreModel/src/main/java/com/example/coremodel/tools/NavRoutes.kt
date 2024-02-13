package com.example.coremodel.tools

sealed class AppNavRoute(val route: String) {
    object MainScreen : AppNavRoute("main_screen")
    object AddProductScreen : AppNavRoute("addProduct_screen")
    object AddCategoryScreen: AppNavRoute("addCategory_screen")
    object EditProductScreen : AppNavRoute("editProduct_screen")
    object CameraScreen : AppNavRoute("camera_screen")
    object BarcodeCameraScreen : AppNavRoute("barcode_camera_screen")
}
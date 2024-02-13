object Config {
    const val applicationId = "com.example.topcart"
    const val compileSdk = 34
    const val minSdk = 24
    const val targetSdk = 33
    const val buildToolsVersion = "33.0.0"
}

object Compose {
    const val kotlinCompilerExtensionVersion = "1.4.3"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val featureStartScreen = ":featureStartScreen"
    const val featureAddProduct = ":featureAddProduct"
    const val coreUI = ":core:coreUI"
    const val coreModel = ":core:coreModel"
    const val dataSource = ":dataSource"
    const val shareViewModel = ":sharedViewModel"
    const val featureCamera = ":featureCamera"
    }

object Versions {



    //Kotlin
    const val core = "1.9.0"
    const val stdlib = "1.8.10"
    const val coroutinesCore = "1.6.4"
    const val coroutinesAndroid = "1.6.4"
    const val appCompat = "1.6.1"
    const val material = "1.11.0"

    //Coil
    const val coil = "2.2.2"

    //Room
    const val roomVersion = "2.5.0"

    //Test

    //Navigation
    const val navigation = "2.5.3"

    //Lifecycle
    const val lifecycle = "2.6.1"

    //Compose
    const val composeBom = "2024.02.00"
    const val composeActivity = "1.6.1"
    const val composeViewModel = "2.6.1"

    //Koin
    const val koin = "3.4.2"

    //CameraX
    const val cameraX = "1.3.0-alpha05"

    const val accompanist = "0.31.0-alpha"

}

object KoinCompose{
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
}

object Lifecycle {
    const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
}

object Accompanist{
    const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
}

object CameraX{
    const val core = "androidx.camera:camera-core:${Versions.cameraX}"
    const val view = "androidx.camera:camera-view:${Versions.cameraX}"
    const val lifecycle = "androidx.camera:camera-lifecycle:${Versions.cameraX}"
    const val extensions = "androidx.camera:camera-extensions:${Versions.cameraX}"
    const val mlKit = "androidx.camera:camera-mlkit-vision:${Versions.cameraX}"
    const val camera2 = "androidx.camera:camera-camera2:${Versions.cameraX}"
    const val barcodeScanner = "com.google.mlkit:barcode-scanning:17.1.0"
}

object ComposeUi {
    const val bom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val ui = "androidx.compose.ui:ui"
    const val material3 = "androidx.compose.material3:material3"
    const val preview = "androidx.compose.ui:ui-tooling-preview"
    const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val graphics = "androidx.compose.ui:ui-graphics"
    const val debugImplComposePreview = "androidx.compose.ui:ui-tooling"
    const val debugImplComposeTestManifest = "androidx.compose.ui:ui-test-manifest"
}


object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.stdlib}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object Coil {
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomPaging = "androidx.room:room-paging:${Versions.roomVersion}"
}

object TestImpl {

}

object NavigationComponent {
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
}

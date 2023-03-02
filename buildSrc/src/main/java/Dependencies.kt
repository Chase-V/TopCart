object Config {
    const val applicationId = "com.example.topcart"
    const val compileSdk = 33
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
}

object Versions {

    //Kotlin
    const val core = "1.9.0"
    const val stdlib = "1.8.10"
    const val coroutinesCore = "1.6.4"
    const val coroutinesAndroid = "1.6.4"

    //Coil
    const val coil = "2.2.2"

    //Room
    const val roomKtx = "2.5.0"
    const val runtime = "2.5.0"
    const val roomCompiler = "2.5.0"

    //Test

    //Navigation
    const val navigation = "2.5.3"

    //Lifecycle
    const val lifecycle = "2.5.1"

    //Compose
    const val composeBom = "2023.01.00"
    const val composeActivity = "1.6.1"
    const val composeViewModel = "2.5.1"
}

object Lifecycle {
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
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
}


object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.stdlib}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Coil {
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object TestImpl {

}

object NavigationComponent {
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
}
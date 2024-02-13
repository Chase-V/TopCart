plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.featurecamera"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.kotlinCompilerExtensionVersion
    }
}

dependencies {

    implementation(project(Modules.coreUI))

    //Navigation
    implementation(NavigationComponent.navigation)

    //CameraX
    implementation(CameraX.core)
    implementation(CameraX.camera2)
    implementation(CameraX.view)
    implementation(CameraX.lifecycle)
    implementation(CameraX.extensions)
    implementation(CameraX.mlKit)
    implementation(CameraX.barcodeScanner)

    //Accompanist
    implementation(Accompanist.permissions)

    //Kotlin
    implementation(Kotlin.core)
    implementation(Kotlin.stdlib)
    implementation(Kotlin.coroutinesAndroid)

    //Lifecycle
    implementation(Lifecycle.lifecycle)

    implementation(platform(ComposeUi.bom))
    implementation(ComposeUi.ui)
    implementation(ComposeUi.material3)
    implementation(ComposeUi.preview)
    implementation(ComposeUi.activity)
    implementation(ComposeUi.viewModel)
    implementation(ComposeUi.graphics)
    debugImplementation(ComposeUi.debugImplComposeTestManifest)
    debugImplementation(ComposeUi.debugImplComposePreview)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
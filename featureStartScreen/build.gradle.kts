plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.featurestartscreen"
}

dependencies {

    implementation(project(Modules.core))

    //Navigation
    implementation(NavigationComponent.navigation)

    //Kotlin
    implementation(Kotlin.core)
    implementation(Kotlin.stdlib)
    implementation(Kotlin.coroutinesAndroid)

    //Lifecycle
    implementation(Lifecycle.lifecycle)

    //Coil
    implementation(Coil.coil)

    //Compose
    implementation(platform(ComposeUi.bom))
    implementation(ComposeUi.ui)
    implementation(ComposeUi.material3)
    implementation(ComposeUi.preview)
    implementation(ComposeUi.activity)
    implementation(ComposeUi.viewModel)
    implementation(ComposeUi.graphics)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
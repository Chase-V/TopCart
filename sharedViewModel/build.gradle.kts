plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.sharedviewmodel"
}

dependencies {

    implementation(project(Modules.coreModel))
    implementation(project(Modules.dataSource))
    implementation(Kotlin.coroutinesAndroid)
    implementation(Kotlin.core)
    implementation(ComposeUi.viewModel)
    implementation(KoinCompose.koinCompose)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
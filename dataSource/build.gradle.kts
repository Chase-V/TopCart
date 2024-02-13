plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.datasource"
}

dependencies {
    implementation(project(Modules.coreModel))

    implementation(Room.roomKtx)
    kapt(Room.compiler)
    implementation(Room.runtime)
    implementation(Kotlin.coroutinesAndroid)

    implementation(Kotlin.core)
    implementation(Kotlin.appCompat)
    implementation(Kotlin.material)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
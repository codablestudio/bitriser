plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.androidExtensions)
    kotlin(Plugins.Kotlin.kapt)
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        applicationId = "studio.codable.bitriser"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

//    signingConfigs {
//        create("release") {
//
//        }
//    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlin)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.constraintLayout)

    implementation(Dependencies.OkHttp.core)
    implementation(Dependencies.OkHttp.interceptor)

    implementation(Dependencies.timber)

    testImplementation("junit:junit:4.13")
    androidTestImplementation(Dependencies.AndroidX.junit)
    androidTestImplementation(Dependencies.AndroidX.espresso)
}
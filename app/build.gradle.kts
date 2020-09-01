import java.util.Properties
import java.io.FileInputStream

plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.androidExtensions)
    kotlin(Plugins.Kotlin.kapt)
}

val file = rootProject.file("api.properties")
val apiProperties = Properties()
apiProperties.load(FileInputStream(file))

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

    packagingOptions{
        exclude("META-INF/*.kotlin_module")
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

        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://api.bitrise.io/\"")
            buildConfigField("String", "API_VERSION", "\"v0.1/\"")
            buildConfigField("String", "PERSONAL_ACCESS_TOKEN", "${apiProperties["PERSONAL_ACCESS_TOKEN"]}")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions{
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.reflect)

    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.constraintLayout)

    implementation(Dependencies.AndroidX.Ktx.core)
    implementation(Dependencies.AndroidX.Ktx.activity)
    implementation(Dependencies.AndroidX.Ktx.viewModel)

    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.viewModel)

    implementation(Dependencies.OkHttp.core)
    implementation(Dependencies.OkHttp.interceptor)

    implementation(Dependencies.timber)

    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.moshiConverter)

//    implementation(Dependencies.Moshi.core)
//    implementation(Dependencies.Moshi.adapters)
//    kapt(Dependencies.Moshi.codegen)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.Koin.test)

    androidTestImplementation(Dependencies.AndroidX.junit)
    androidTestImplementation(Dependencies.AndroidX.espresso)
}

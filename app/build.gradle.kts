import java.io.FileInputStream
import java.util.Properties

plugins {
    id(Plugins.Android.application)
    kotlin(Plugins.Android.android)
    kotlin(Plugins.Android.extensions)
    kotlin(Plugins.Kotlin.kapt)
//    id("kotlin-android")
    id("com.yelp.codegen.plugin") version "1.4.1"
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

        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        this.compose = true
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
        useIR = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.AndroidX.compose
        kotlinCompilerVersion = Versions.kotlin
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Dependencies.material)

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.reflect)

    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.constraintLayout)

    implementation(Dependencies.AndroidX.Ktx.core)
    implementation(Dependencies.AndroidX.Ktx.activity)
    implementation(Dependencies.AndroidX.Ktx.viewModel)
    implementation(Dependencies.AndroidX.Ktx.liveData)

    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.viewModel)

    implementation(Dependencies.OkHttp.core)
    implementation(Dependencies.OkHttp.interceptor)

    implementation(Dependencies.timber)

    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.moshiConverter)

    implementation(Dependencies.AndroidX.Compose.ui)
    implementation(Dependencies.AndroidX.Compose.uiTooling)
    implementation(Dependencies.AndroidX.Compose.foundation)
    implementation(Dependencies.AndroidX.Compose.foundationLayout)
    implementation(Dependencies.AndroidX.Compose.Material.core)
    implementation(Dependencies.AndroidX.Compose.Material.iconsCore)
    implementation(Dependencies.AndroidX.Compose.Material.iconsExtended)
    implementation(Dependencies.AndroidX.Compose.Runtime.core)
    implementation(Dependencies.AndroidX.Compose.Runtime.livedata)

    implementation(Dependencies.Moshi.core)
    implementation(Dependencies.Moshi.adapters)
    implementation(Dependencies.Moshi.kotlin)
    kapt(Dependencies.Moshi.codegen)

    implementation ("com.jakewharton.threetenabp:threetenabp:1.2.2")

    implementation ("com.github.zsoltk:compose-router:0.17.0")

//    implementation ("androidx.multidex:multidex:2.0.1")
     
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.Koin.test)

    androidTestImplementation(Dependencies.AndroidX.junit)
    androidTestImplementation(Dependencies.AndroidX.espresso)
}

generateSwagger {
    platform = "kotlin-coroutines"
    packageName = "studio.codable.bitriser.util.networking"
    specVersion = "1.0.0"
    inputFile = file("../app/bitrise_api_swagger.json")
    outputDir = project.layout.projectDirectory.dir("./src/main/java").asFile
}

// Compiler flag to use experimental Compose APIs
//tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile).configureEach {
//    kotlinOptions {
//        jvmTarget = "1.8"
//        freeCompilerArgs += [
//            "-Xopt-in=kotlin.RequiresOptIn"
//        ]
//    }
//}

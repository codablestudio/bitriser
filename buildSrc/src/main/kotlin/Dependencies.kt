object Versions {

    object AndroidX {
        const val coreKtx = "1.3.1"
        const val appCompat = "1.2.0"
        const val constraintLayout = "1.1.3"
        const val junit = "1.1.1"
        const val espresso = "3.2.0"
    }

    const val kotlin = "1.3.72"
    const val okHttp = "4.8.1"
    const val timber = "4.7.1"
    const val koin = "2.1.5"
    const val junit = "4.13"
}

object Dependencies {

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val junit = "androidx.test.ext:junit:${Versions.AndroidX.junit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidX.espresso}"
    }

    object Koin {
        const val android = "org.koin:koin-android:$${Versions.koin}"
        const val viewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

        const val test = "org.koin:koin-test:${Versions.koin}"
    }

    object OkHttp {
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
        const val core = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val junit = "junit:junit:${Versions.junit}"
}

object Plugins {

    const val androidApplication = "com.android.application"

    object Kotlin {

        const val androidExtensions = "android.extensions"
        const val kapt = "kapt"
        const val android = "android"
    }
}
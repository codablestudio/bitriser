object Versions {

    object AndroidX {
        const val coreKtx = "1.3.1"
        const val appCompat = "1.2.0"
        const val constraintLayout = "1.1.3"
        const val junit = "1.1.1"
        const val espresso = "3.2.0"

        object Ktx{
            const val viewModel = "2.2.0"
            const val activity = "1.1.0"
            const val core = "1.3.1"
        }
    }

    const val kotlin = "1.4.0"
    const val okHttp = "4.8.1"
    const val timber = "4.7.1"
    const val koin = "2.2.0-alpha-1"
    const val junit = "4.13"
    const val retrofit = "2.8.1"
    const val moshi = "1.9.3"
}

object Dependencies {

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val junit = "androidx.test.ext:junit:${Versions.AndroidX.junit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidX.espresso}"

        object Ktx{
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.Ktx.viewModel}"
            const val activity = "androidx.activity:activity-ktx:${Versions.AndroidX.Ktx.activity}"
            const val core = "androidx.core:core-ktx:${Versions.AndroidX.Ktx.core}"
        }
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

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val moshiConverter =  "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object Moshi {
        const val core = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }

    object Kotlin{
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    }

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

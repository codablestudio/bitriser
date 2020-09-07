object Versions {

    object AndroidX {
        const val appCompat = "1.2.0"
        const val constraintLayout = "1.1.3"
        const val junit = "1.1.1"
        const val espresso = "3.2.0"
        const val compose = "1.0.0-alpha01"

        object Ktx {
            const val viewModel = "2.2.0"
            const val activity = "1.1.0"
            const val core = "1.3.1"
            const val liveData = "2.2.0"
        }
    }

    const val kotlin = "1.4.0"
    const val okHttp = "4.8.1"
    const val timber = "4.7.1"
    const val koin = "2.2.0-alpha-1"
    const val junit = "4.13"
    const val retrofit = "2.8.1"
    const val moshi = "1.9.2"
    const val material = "1.2.0"
}

object Dependencies {

    const val material = "com.google.android.material:material:${Versions.material}"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val junit = "androidx.test.ext:junit:${Versions.AndroidX.junit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidX.espresso}"

        object Compose {

            const val animation =
                "androidx.compose.animation:animation:${Versions.AndroidX.compose}"
            const val ui = "androidx.compose.ui:ui:${Versions.AndroidX.compose}"
            const val uiTooling = "androidx.ui:ui-tooling:${Versions.AndroidX.compose}"
            const val foundation =
                "androidx.compose.foundation:foundation:${Versions.AndroidX.compose}"
            const val foundationLayout =
                "androidx.compose.foundation:foundation-layout:${Versions.AndroidX.compose}"

            object Material {
                const val core = "androidx.compose.material:material:${Versions.AndroidX.compose}"
                const val iconsCore = "androidx.compose.material:material-icons-core:${Versions.AndroidX.compose}"
                const val iconsExtended = "androidx.compose.material:material-icons-extended:${Versions.AndroidX.compose}"
            }

            object Runtime{
                const val core = "androidx.compose.runtime:runtime:${Versions.AndroidX.compose}"
                const val livedata =
                    "androidx.compose.runtime:runtime-livedata:${Versions.AndroidX.compose}"

            }
        }

        object Ktx {
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.Ktx.viewModel}"
            const val activity = "androidx.activity:activity-ktx:${Versions.AndroidX.Ktx.activity}"
            const val core = "androidx.core:core-ktx:${Versions.AndroidX.Ktx.core}"
            const val liveData =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.Ktx.liveData}"
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
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object Moshi {
        const val core = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    }

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val junit = "junit:junit:${Versions.junit}"
}

object Plugins {

    object Android {
        const val android = "android"
        const val application = "com.android.application"
        const val extensions = "android.extensions"
    }

    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin.android"
        const val kapt = "kapt"
    }
}

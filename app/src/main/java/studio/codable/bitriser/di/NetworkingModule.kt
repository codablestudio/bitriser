package studio.codable.bitriser.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import studio.codable.bitriser.BuildConfig
import studio.codable.bitriser.util.networking.api.ApplicationApi
import studio.codable.bitriser.util.networking.interceptor.AuthInterceptor

val networkingModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideApplicationApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.apply { this.level = HttpLoggingInterceptor.Level.BODY }

    return OkHttpClient()
        .newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()
}

fun provideApplicationApi(retrofit: Retrofit): ApplicationApi {
    return retrofit.create(ApplicationApi::class.java)
}
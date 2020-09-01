package studio.codable.bitriser.di

//import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import studio.codable.bitriser.BuildConfig
import studio.codable.bitriser.util.networking.api.application.ApplicationApi
import studio.codable.bitriser.util.networking.interceptor.AuthInterceptor

val networkingModule = module {
    factory { AuthInterceptor() }
    factory { provideMoshi() }
    factory { provideOkHttpClient(get()) }
    factory { provideApplicationApi(get()) }
    single { provideRetrofit(get(), get()) }
}

fun provideMoshi(): Moshi = Moshi.Builder()
//    .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
    .build()

fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).client(okHttpClient).build()
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
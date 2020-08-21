package studio.codable.bitriser.di

import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import studio.codable.bitriser.BuildConfig
import studio.codable.bitriser.MainViewModel
import studio.codable.bitriser.util.networking.api.ApplicationApi
import studio.codable.bitriser.util.networking.interceptor.AuthInterceptor

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
}
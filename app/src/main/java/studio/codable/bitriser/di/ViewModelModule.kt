package studio.codable.bitriser.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import studio.codable.bitriser.MainViewModel

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
}
package studio.codable.bitriser.di

import org.koin.dsl.module
import studio.codable.bitriser.util.repository.application.ApplicationRepository
import studio.codable.bitriser.util.repository.application.IApplicationRepository

val repositoryModule = module {
    factory<IApplicationRepository> { ApplicationRepository(get()) }
}
package studio.codable.bitriser.di

import org.koin.dsl.module
import studio.codable.bitriser.util.repository.ApplicationRepository
import studio.codable.bitriser.util.repository.IApplicationRepository

val repositoryModule = module {
    factory<IApplicationRepository> { ApplicationRepository(get()) }
}
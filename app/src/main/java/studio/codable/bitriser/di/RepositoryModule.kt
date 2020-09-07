package studio.codable.bitriser.di

import org.koin.dsl.module
import studio.codable.bitriser.util.repository.application.ApplicationRepository
import studio.codable.bitriser.util.repository.application.IApplicationRepository
import studio.codable.bitriser.util.repository.builds.BuildsRepository
import studio.codable.bitriser.util.repository.builds.IBuildsRepository

val repositoryModule = module {
    factory<IApplicationRepository> { ApplicationRepository(get()) }
    factory <IBuildsRepository>{BuildsRepository(get())}
}
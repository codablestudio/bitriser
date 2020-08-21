package studio.codable.bitriser.util.repository

import studio.codable.bitriser.util.networking.api.ApplicationApi

class ApplicationRepository(private val applicationApi: ApplicationApi) : IApplicationRepository {

    override suspend fun getApps() {
        applicationApi.getApps()
    }
}
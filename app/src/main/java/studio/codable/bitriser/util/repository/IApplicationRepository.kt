package studio.codable.bitriser.util.repository

import studio.codable.bitriser.util.networking.NetworkResult

interface IApplicationRepository {
    suspend fun getApps(): NetworkResult<Unit>

    suspend fun getApp(appSlug : String): NetworkResult<Unit>
}
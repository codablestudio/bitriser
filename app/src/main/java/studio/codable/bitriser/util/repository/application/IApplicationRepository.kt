package studio.codable.bitriser.util.repository.application

import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.models.V0AppListResponseModel

interface IApplicationRepository {
    suspend fun getApps(): NetworkResult<List<AppInfo>>

    suspend fun getApp(appSlug : String): NetworkResult<Unit>
}
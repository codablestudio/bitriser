package studio.codable.bitriser.util.repository

import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AppItemResponse

interface IApplicationRepository {
    suspend fun getApps(): NetworkResult<List<AppItemResponse>>

    suspend fun getApp(appSlug : String): NetworkResult<Unit>
}
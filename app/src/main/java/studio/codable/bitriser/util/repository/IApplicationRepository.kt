package studio.codable.bitriser.util.repository

import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.api.application.model.request.GetAppsRequest

interface IApplicationRepository {
    suspend fun getApps(sortOrder: GetAppsRequest.SortOrder): NetworkResult<Unit>
}
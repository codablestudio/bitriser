package studio.codable.bitriser.util.repository

import studio.codable.bitriser.base.BaseRepository
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.api.application.ApplicationApi
import studio.codable.bitriser.util.networking.api.application.model.request.GetAppsRequest
import timber.log.Timber

class ApplicationRepository(private val applicationApi: ApplicationApi) : BaseRepository(), IApplicationRepository {

    override suspend fun getApps(sortOrder: GetAppsRequest.SortOrder): NetworkResult<Unit> {
        return callApi {
            applicationApi.getApps(
                GetAppsRequest(
                    sortOrder,
                    "",
                    20
                )
            )
        }.process {
            Unit
        }
    }

    override suspend fun getApp(appSlug: String): NetworkResult<Unit> {
        return callApi {
            applicationApi.getApp(appSlug)
        }.process {
            Timber.i(it.toString())
            Unit
        }
    }
}
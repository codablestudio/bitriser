package studio.codable.bitriser.util.repository

import studio.codable.bitriser.base.BaseRepository
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.api.application.ApplicationApi
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AppItemResponse
import timber.log.Timber

class ApplicationRepository(private val applicationApi: ApplicationApi) : BaseRepository(),
    IApplicationRepository {

    override suspend fun getApps(): NetworkResult<List<AppItemResponse>> {
        return callApi { applicationApi.apps("", "", 50) }.process { it.data }
    }

    override suspend fun getApp(appSlug: String): NetworkResult<Unit> {
        return callApi {
            applicationApi.app(appSlug)
        }.process {
            Timber.i(it.toString())
            Unit
        }
    }
}
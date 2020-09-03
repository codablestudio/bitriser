package studio.codable.bitriser.util.repository.application

import studio.codable.bitriser.base.BaseRepository
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.model.OwnerAccount
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.apis.ApplicationApi
import timber.log.Timber

class ApplicationRepository(private val applicationApi: ApplicationApi) : BaseRepository(),
    IApplicationRepository {

    override suspend fun getApps(): NetworkResult<List<AppInfo>> {
        return callApi { applicationApi.appList(null, null, null) } process {
            it.data?.map { networkModel ->
                with(networkModel) {
                    AppInfo(
                        avatarUrl,
                        isDisabled,
                        isPublic,
                        OwnerAccount(owner?.accountType, owner?.name, owner?.slug),
                        projectType,
                        provider,
                        repoOwner,
                        repoSlug,
                        repoUrl,
                        slug,
                        status,
                        title
                    )
                }
            } ?: emptyList()
        }
    }

    override suspend fun getApp(appSlug: String): NetworkResult<Unit> {
        return callApi {
            applicationApi.appShow(appSlug)
        } process {
            Timber.i(it.toString())
            Unit
        }
    }
}
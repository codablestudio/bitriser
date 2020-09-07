package studio.codable.bitriser.util.repository.builds

import studio.codable.bitriser.base.BaseRepository
import studio.codable.bitriser.model.BuildInfo
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.apis.BuildsApi

class BuildsRepository(private val buildsApi: BuildsApi) : BaseRepository(), IBuildsRepository {

    override suspend fun getBuilds(): NetworkResult<List<BuildInfo>> {
        return callApi { buildsApi.buildListAll() } process {
            it.data?.map { item ->
              BuildInfo(item)
            } ?: emptyList()
        }
    }
}
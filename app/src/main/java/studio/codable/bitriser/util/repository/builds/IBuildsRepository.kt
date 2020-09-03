package studio.codable.bitriser.util.repository.builds

import studio.codable.bitriser.model.BuildInfo
import studio.codable.bitriser.util.networking.NetworkResult

interface IBuildsRepository {

    suspend fun getBuilds(appSlug: String): NetworkResult<List<BuildInfo>>
}
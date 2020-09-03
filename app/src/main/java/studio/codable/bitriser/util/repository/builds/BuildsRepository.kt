package studio.codable.bitriser.util.repository.builds

import studio.codable.bitriser.base.BaseRepository
import studio.codable.bitriser.model.BuildInfo
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.apis.BuildsApi

class BuildsRepository(private val buildsApi: BuildsApi) : BaseRepository(), IBuildsRepository {

    override suspend fun getBuilds(appSlug: String): NetworkResult<List<BuildInfo>> {
        return callApi { buildsApi.buildList(appSlug) } process {
            it.data?.map { item ->
                with(item) {
                    BuildInfo(
                        abortReason,
                        branch,
                        buildNumber,
                        commitHash,
                        commitMessage,
                        commitViewUrl,
                        environmentPrepareFinishedAt,
                        finishedAt,
                        isOnHold,
                        machineTypeId,
                        originalBuildParams,
                        pullRequestId,
                        pullRequestTargetBranch,
                        pullRequestViewUrl,
                        slug,
                        stackIdentifier,
                        startedOnWorkerAt,
                        status,
                        statusText,
                        tag,
                        triggeredAt,
                        triggeredBy,
                        triggeredWorkflow
                    )
                }
            } ?: emptyList()
        }
    }
}
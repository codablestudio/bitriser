package studio.codable.bitriser.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import studio.codable.bitriser.util.networking.models.V0BuildListAllResponseItemModel

data class BuildInfo(
    var abortReason: String? = null,
    var branch: String? = null,
    var buildNumber: Int? = null,
    var commitHash: String? = null,
    var commitMessage: String? = null,
    var commitViewUrl: String? = null,
    var environmentPrepareFinishedAt: String? = null,
    var finishedAt: String? = null,
    var isOnHold: Boolean? = null,
    var machineTypeId: String? = null,
    var originalBuildParams: BuildParams? = null,
    var pullRequestId: Int? = null,
    var pullRequestTargetBranch: String? = null,
    var pullRequestViewUrl: String? = null,
    var repository: AppInfo? = null,
    var slug: String? = null,
    var stackIdentifier: String? = null,
    var startedOnWorkerAt: String? = null,
    var status: Int? = null,
    var statusText: String? = null,
    var tag: String? = null,
    var triggeredAt: String? = null,
    var triggeredBy: String? = null,
    var triggeredWorkflow: String? = null
) {
    @JsonClass(generateAdapter = true)
    data class BuildParams(
        @field:Json(name = "commit_hash")
        val commitHash: String? = null,
        @field:Json(name = "commit_message")
        val commitMessage: String? = null,
        @field:Json(name = "branch")
        val branch: String? = null,
        @field:Json(name = "branch_repo_owner")
        val branchRepoOwner: String?,
        @field:Json(name = "branch_dest")
        val branchDest: String? = null,
        @field:Json(name = "branch_dest_repo_owner")
        val branchDestRepoOwner: String? = null,
        @field:Json(name = "pull_requestId")
        val pullRequestId: String? = null,
        @field:Json(name = "pull_request_repository_url")
        val pullRequestRepositoryUrl: String? = null,
        @field:Json(name = "pull_request_merge_branch")
        val pullRequestMergeBranch: String? = null,
        @field:Json(name = "pull_request_head_branch")
        val pullRequestHeadBranch: String? = null,
        @field:Json(name = "pull_request_author")
        val pullRequestAuthor: String? = null,
        @field:Json(name = "diff_url")
        val diffUrl: String? = null,
//        @field:Json(name = "commit_paths")
//        val commitPaths: List<String>? = null,
        @field:Json(name = "check_run_id")
        val checkRunId: Int? = null
    )

    constructor(networkingModel: V0BuildListAllResponseItemModel?) :this(abortReason = networkingModel?.abortReason,
            branch = networkingModel?.branch,
            buildNumber = networkingModel?.buildNumber,
            commitHash = networkingModel?.commitHash,
            commitMessage = networkingModel?.commitMessage,
            commitViewUrl = networkingModel?.commitViewUrl,
            environmentPrepareFinishedAt = networkingModel?.environmentPrepareFinishedAt,
            finishedAt = networkingModel?.finishedAt,
            isOnHold = networkingModel?.isOnHold,
            machineTypeId = networkingModel?.machineTypeId,
            originalBuildParams = networkingModel?.originalBuildParams,
            pullRequestId = networkingModel?.pullRequestId,
            pullRequestTargetBranch = networkingModel?.pullRequestTargetBranch,
            pullRequestViewUrl = networkingModel?.pullRequestViewUrl,
            repository = AppInfo(networkingModel?.repository),
            slug = networkingModel?.slug,
            stackIdentifier = networkingModel?.stackIdentifier,
            startedOnWorkerAt = networkingModel?.startedOnWorkerAt,
            status = networkingModel?.status,
            statusText = networkingModel?.statusText,
            tag = networkingModel?.tag,
            triggeredAt = networkingModel?.triggeredAt,
            triggeredBy = networkingModel?.triggeredBy,
            triggeredWorkflow = networkingModel?.triggeredWorkflow)
}
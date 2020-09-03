package studio.codable.bitriser.model

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
    var originalBuildParams: String? = null,
    var pullRequestId: Int? = null,
    var pullRequestTargetBranch: String? = null,
    var pullRequestViewUrl: String? = null,
    var slug: String? = null,
    var stackIdentifier: String? = null,
    var startedOnWorkerAt: String? = null,
    var status: Int? = null,
    var statusText: String? = null,
    var tag: String? = null,
    var triggeredAt: String? = null,
    var triggeredBy: String? = null,
    var triggeredWorkflow: String? = null
)
package studio.codable.bitriser.model

data class AppInfo(
    var avatarUrl: String? = null,
    var isDisabled: Boolean? = null,
    var isPublic: Boolean? = null,
    var owner: OwnerAccount? = null,
    var projectType: String? = null,
    var provider: String? = null,
    var repoOwner: String? = null,
    var repoSlug: String? = null,
    var repoUrl: String? = null,
    var slug: String? = null,
    var status: Int? = null,
    var title: String? = null
)
package studio.codable.bitriser.model

import studio.codable.bitriser.util.networking.models.V0AppResponseItemModel

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
) {
    constructor(networkingModel: V0AppResponseItemModel?) : this(
        avatarUrl = networkingModel?.avatarUrl,
        isDisabled = networkingModel?.isDisabled,
        isPublic = networkingModel?.isPublic,
        owner = OwnerAccount(networkingModel?.owner),
        projectType = networkingModel?.projectType,
        provider = networkingModel?.provider,
        repoOwner = networkingModel?.repoOwner,
        repoSlug = networkingModel?.repoSlug,
        repoUrl = networkingModel?.repoUrl,
        slug = networkingModel?.slug,
        status = networkingModel?.status,
        title = networkingModel?.title
    )
}
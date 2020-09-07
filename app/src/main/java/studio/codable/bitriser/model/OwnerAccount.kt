package studio.codable.bitriser.model

import studio.codable.bitriser.util.networking.models.V0OwnerAccountResponseModel

data class OwnerAccount(
    var accountType: String? = null,
    var name: String? = null,
    var slug: String? = null
) {
    constructor(networkingModel: V0OwnerAccountResponseModel?) : this(
        accountType = networkingModel?.accountType,
        name = networkingModel?.name,
        slug = networkingModel?.slug
    )
}
package studio.codable.bitriser.util.networking.api.application.model.response.submodel

import com.squareup.moshi.Json

data class AccountOwnerResponse(
    @field:Json(name = "account_type")
    val accountType: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "slug")
    val slug: String
)
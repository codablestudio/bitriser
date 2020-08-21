package studio.codable.bitriser.util.networking.api.application.model.request

import com.squareup.moshi.Json

data class GetAppsRequest(
    @field:Json(name = "sort_by")
    val sortBy: SortOrder?,
    @field:Json(name = "next")
    val next: String?,
    @field:Json(name = "limit")
    val limit: Int?
) {
    enum class SortOrder {
        @field:Json(name = "last_build_at")
        LAST_BUILD_AT,

        @field:Json(name = "created_at")
        CREATED_AT
    }
}
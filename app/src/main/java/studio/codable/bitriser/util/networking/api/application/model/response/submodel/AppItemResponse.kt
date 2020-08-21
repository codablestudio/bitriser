package studio.codable.bitriser.util.networking.api.application.model.response.submodel

import com.squareup.moshi.Json

data class AppItemResponse(
    @field:Json(name = "avatar_url")
    val avatarUrl: String,
    @field:Json(name = "is_disabled")
    val isDisabled: Boolean,
    @field:Json(name = "isPublic")
    val isPublic: Boolean,
    @field:Json(name = "owner")
    val owner: AccountOwnerResponse,
    @field:Json(name = "project_type")
    val projectType: String,
    @field:Json(name = "provider")
    val provider: String,
    @field:Json(name = "repo_owner")
    val repoOwner: String,
    @field:Json(name = "repo_slug")
    val repoSlug: String,
    @field:Json(name = "repo_url")
    val repoUrl: String,
    @field:Json(name = "slug")
    val slug: String,
    @field:Json(name = "status")
    val status: Int,
    @field:Json(name = "title")
    val title: String
)
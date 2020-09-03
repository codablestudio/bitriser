package studio.codable.bitriser.util.networking

import com.squareup.moshi.Json

data class ErrorResponseModel(
    @field:Json(name = "message")
    val message: String
)
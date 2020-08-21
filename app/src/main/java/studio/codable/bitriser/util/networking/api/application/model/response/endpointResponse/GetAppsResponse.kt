package studio.codable.bitriser.util.networking.api.application.model.response.endpointResponse

import com.squareup.moshi.Json
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AppItemResponse
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.PagingResponse

data class GetAppsResponse(
    @field:Json(name = "data")
    val data: List<AppItemResponse>,
    @field:Json(name = "paging")
    val paging: PagingResponse
)
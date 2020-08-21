package studio.codable.bitriser.util.networking.api.application.model.response.submodel

import com.squareup.moshi.Json

data class PagingResponse(
    @field:Json(name = "next")
    val next:String,
    @field:Json(name = "page_item_list")
    val pageItemList: Int,
    @field:Json(name = "total_item_count")
    val totalItemCount: Int
)
package studio.codable.bitriser.util.networking.api.application

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import studio.codable.bitriser.util.networking.api.application.model.response.endpointResponse.GetAppsResponse

interface ApplicationApi {
    @GET("v0.1/apps")
    suspend fun apps(@Query("sort_by") sortBy: String?, @Query("next") next:String?, @Query("limit") limit: Int?): GetAppsResponse

    @GET("v0.1/apps/{app-slug}")
    suspend fun app(@Path("app-slug") appSlug: String)
}
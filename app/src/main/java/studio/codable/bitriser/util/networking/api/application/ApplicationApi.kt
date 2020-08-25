package studio.codable.bitriser.util.networking.api.application

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import studio.codable.bitriser.BuildConfig
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.api.application.model.request.GetAppsRequest
import studio.codable.bitriser.util.networking.api.application.model.response.endpointResponse.GetAppsResponse
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AppItemResponse

interface ApplicationApi {

    @GET("v0.1/apps")
    suspend fun getApps(@Body getAppsRequest: GetAppsRequest): GetAppsResponse

    @GET("v0.1/apps/{app-slug}")
    suspend fun getApp(@Path("app-slug") appSlug : String): AppItemResponse

}
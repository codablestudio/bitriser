package studio.codable.bitriser.util.networking.api.application

import retrofit2.http.Body
import retrofit2.http.GET
import studio.codable.bitriser.BuildConfig
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.api.application.model.request.GetAppsRequest
import studio.codable.bitriser.util.networking.api.application.model.response.endpointResponse.GetAppsResponse

interface ApplicationApi {

    @GET("v0.1/apps")
    suspend fun getApps(@Body getAppsRequest: GetAppsRequest): GetAppsResponse
}
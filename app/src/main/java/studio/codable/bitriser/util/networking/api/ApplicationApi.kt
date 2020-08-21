package studio.codable.bitriser.util.networking.api

import retrofit2.http.GET
import studio.codable.bitriser.BuildConfig

interface ApplicationApi {

    @GET("v0.1/apps")
    suspend fun getApps()
}
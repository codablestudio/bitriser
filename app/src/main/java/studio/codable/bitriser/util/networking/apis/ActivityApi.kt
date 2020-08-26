/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.apis

import retrofit2.http.GET
import retrofit2.http.Headers
import studio.codable.bitriser.util.networking.models.ServiceStandardErrorRespModel
import studio.codable.bitriser.util.networking.models.V0ActivityEventListResponseModel

@JvmSuppressWildcards
interface ActivityApi {
    /**
     * Get list of Bitrise activity events
     * List all the Bitrise activity events
     * The endpoint is owned by defaultname service owner
     * @param next Slug of the first activity event in the response (optional)
     * @param limit Max number of elements per page (default: 50) (optional)
     */
    @Headers(
        "X-Operation-ID: activity-list"
    )
    @GET("me/activities")
    suspend fun activityList(
        @retrofit2.http.Query("next") next: String?,
        @retrofit2.http.Query("limit") limit: Int?
    ): V0ActivityEventListResponseModel
}

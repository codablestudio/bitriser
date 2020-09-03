/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.apis

import retrofit2.http.GET
import retrofit2.http.Headers
import studio.codable.bitriser.util.networking.models.ServiceStandardErrorRespModel
import studio.codable.bitriser.util.networking.models.V0UserPlanRespModel
import studio.codable.bitriser.util.networking.models.V0UserProfileRespModel

@JvmSuppressWildcards
interface UserApi {
    /**
     * The subscription plan of the user
     * Get the subscription of the user: the current plan, any pending plans, and the duration of a trial period if applicable
     * The endpoint is owned by defaultname service owner
     */
    @Headers(
        "X-Operation-ID: user-plan"
    )
    @GET("me/plan")
    suspend fun userPlan(): V0UserPlanRespModel
    /**
     * Get your profile data
     * Shows the authenticated users profile data
     * The endpoint is owned by defaultname service owner
     */
    @Headers(
        "X-Operation-ID: user-profile"
    )
    @GET("me")
    suspend fun userProfile(): V0UserProfileRespModel
    /**
     * Get a specific user
     * Show information about a specific user
     * The endpoint is owned by defaultname service owner
     * @param userSlug User slug (required)
     */
    @Headers(
        "X-Operation-ID: user-show"
    )
    @GET("users/{user-slug}")
    suspend fun userShow(
        @retrofit2.http.Path("user-slug") userSlug: String
    ): V0UserProfileRespModel
}
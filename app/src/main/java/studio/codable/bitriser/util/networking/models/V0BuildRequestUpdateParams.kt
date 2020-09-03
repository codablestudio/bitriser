/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property isApproved
 */
@JsonClass(generateAdapter = true)
data class V0BuildRequestUpdateParams(
    @Json(name = "is_approved") @field:Json(name = "is_approved") var isApproved: Boolean? = null
)
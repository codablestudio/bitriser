/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property filename
 * @property filesize
 */
@JsonClass(generateAdapter = true)
data class V0AvatarCandidateCreateParams(
    @Json(name = "filename") @field:Json(name = "filename") var filename: String? = null,
    @Json(name = "filesize") @field:Json(name = "filesize") var filesize: Int? = null
)

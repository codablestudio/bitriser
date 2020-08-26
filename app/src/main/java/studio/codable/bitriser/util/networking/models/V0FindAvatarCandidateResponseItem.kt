/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property downloadUrl
 * @property filename
 * @property slug
 */
@JsonClass(generateAdapter = true)
data class V0FindAvatarCandidateResponseItem(
    @Json(name = "download_url") @field:Json(name = "download_url") var downloadUrl: String? = null,
    @Json(name = "filename") @field:Json(name = "filename") var filename: String? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null
)

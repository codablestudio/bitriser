/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property isCandidate
 * @property slug
 * @property uploadFileName
 * @property uploadFileSize
 */
@JsonClass(generateAdapter = true)
data class V0AvatarPromoteResponseItemModel(
    @Json(name = "is_candidate") @field:Json(name = "is_candidate") var isCandidate: Boolean? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null,
    @Json(name = "upload_file_name") @field:Json(name = "upload_file_name") var uploadFileName: String? = null,
    @Json(name = "upload_file_size") @field:Json(name = "upload_file_size") var uploadFileSize: Int? = null
)
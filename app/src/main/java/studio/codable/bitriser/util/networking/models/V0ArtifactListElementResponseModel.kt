/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property artifactMeta
 * @property artifactType
 * @property fileSizeBytes
 * @property isPublicPageEnabled
 * @property slug
 * @property title
 */
@JsonClass(generateAdapter = true)
data class V0ArtifactListElementResponseModel(
    @Json(name = "artifact_meta") @field:Json(name = "artifact_meta") var artifactMeta: String? = null,
    @Json(name = "artifact_type") @field:Json(name = "artifact_type") var artifactType: String? = null,
    @Json(name = "file_size_bytes") @field:Json(name = "file_size_bytes") var fileSizeBytes: Int? = null,
    @Json(name = "is_public_page_enabled") @field:Json(name = "is_public_page_enabled") var isPublicPageEnabled: Boolean? = null,
    @Json(name = "slug") @field:Json(name = "slug") var slug: String? = null,
    @Json(name = "title") @field:Json(name = "title") var title: String? = null
)

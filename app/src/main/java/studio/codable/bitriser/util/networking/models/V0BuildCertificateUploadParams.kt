/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property uploadFileName
 * @property uploadFileSize
 */
@JsonClass(generateAdapter = true)
data class V0BuildCertificateUploadParams(
    @Json(name = "upload_file_name") @field:Json(name = "upload_file_name") var uploadFileName: String? = null,
    @Json(name = "upload_file_size") @field:Json(name = "upload_file_size") var uploadFileSize: Int? = null
)

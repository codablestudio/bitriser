/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property certificatePassword
 * @property isExpose
 * @property isProtected
 * @property processed
 */
@JsonClass(generateAdapter = true)
data class V0BuildCertificateUpdateParams(
    @Json(name = "certificate_password") @field:Json(name = "certificate_password") var certificatePassword: String? = null,
    @Json(name = "is_expose") @field:Json(name = "is_expose") var isExpose: Boolean? = null,
    @Json(name = "is_protected") @field:Json(name = "is_protected") var isProtected: Boolean? = null,
    @Json(name = "processed") @field:Json(name = "processed") var processed: Boolean? = null
)

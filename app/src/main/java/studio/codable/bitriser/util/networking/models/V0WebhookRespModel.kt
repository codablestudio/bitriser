/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property status
 */
@JsonClass(generateAdapter = true)
data class V0WebhookRespModel(
    @Json(name = "status") @field:Json(name = "status") var status: String? = null
)

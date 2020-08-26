/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property features
 * @property id
 * @property name
 * @property price
 */
@JsonClass(generateAdapter = true)
data class AddonsPlan(
    @Json(name = "features") @field:Json(name = "features") var features: List<AddonsFeature>? = null,
    @Json(name = "id") @field:Json(name = "id") var id: String? = null,
    @Json(name = "name") @field:Json(name = "name") var name: String? = null,
    @Json(name = "price") @field:Json(name = "price") var price: Int? = null
)

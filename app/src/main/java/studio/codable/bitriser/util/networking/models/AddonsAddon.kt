/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property bannerImage
 * @property cardHeaderColors
 * @property categories
 * @property description
 * @property developerLinks
 * @property documentationUrl
 * @property hasUi
 * @property icon
 * @property id
 * @property isBeta
 * @property plans
 * @property platforms
 * @property previewImages
 * @property setupGuide
 * @property subtitle
 * @property summary
 * @property title
 */
@JsonClass(generateAdapter = true)
data class AddonsAddon(
    @Json(name = "banner_image") @field:Json(name = "banner_image") var bannerImage: String? = null,
    @Json(name = "card_header_colors") @field:Json(name = "card_header_colors") var cardHeaderColors: List<String>? = null,
    @Json(name = "categories") @field:Json(name = "categories") var categories: List<String>? = null,
    @Json(name = "description") @field:Json(name = "description") var description: String? = null,
    @Json(name = "developer_links") @field:Json(name = "developer_links") var developerLinks: List<AddonsDeveloperLink>? = null,
    @Json(name = "documentation_url") @field:Json(name = "documentation_url") var documentationUrl: String? = null,
    @Json(name = "has_ui") @field:Json(name = "has_ui") var hasUi: Boolean? = null,
    @Json(name = "icon") @field:Json(name = "icon") var icon: String? = null,
    @Json(name = "id") @field:Json(name = "id") var id: String? = null,
    @Json(name = "is_beta") @field:Json(name = "is_beta") var isBeta: Boolean? = null,
    @Json(name = "plans") @field:Json(name = "plans") var plans: List<AddonsPlan>? = null,
    @Json(name = "platforms") @field:Json(name = "platforms") var platforms: List<String>? = null,
    @Json(name = "preview_images") @field:Json(name = "preview_images") var previewImages: List<String>? = null,
    @Json(name = "setup_guide") @field:Json(name = "setup_guide") var setupGuide: AddonsSetupGuide? = null,
    @Json(name = "subtitle") @field:Json(name = "subtitle") var subtitle: String? = null,
    @Json(name = "summary") @field:Json(name = "summary") var summary: String? = null,
    @Json(name = "title") @field:Json(name = "title") var title: String? = null
)

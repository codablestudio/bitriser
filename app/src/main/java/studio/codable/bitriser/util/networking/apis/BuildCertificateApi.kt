/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.apis

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import studio.codable.bitriser.util.networking.models.ServiceStandardErrorRespModel
import studio.codable.bitriser.util.networking.models.V0BuildCertificateListResponseModel
import studio.codable.bitriser.util.networking.models.V0BuildCertificateResponseModel
import studio.codable.bitriser.util.networking.models.V0BuildCertificateUpdateParams
import studio.codable.bitriser.util.networking.models.V0BuildCertificateUploadParams

@JvmSuppressWildcards
interface BuildCertificateApi {
    /**
     * Confirm a build certificate upload
     * This is the last step of uploading a build certificate to Bitrise. Confirm the build certificate upload and view the file on the Code Signing tab of a specific app. Read more in our [Confirming the iOS code signing file upload](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#confirming-the-ios-code-signing-file-upload) guide.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildCertificateSlug Build certificate slug (required)
     */
    @Headers(
        "X-Operation-ID: build-certificate-confirm",
      "Content-Type: application/json"
    )
    @POST("apps/{app-slug}/build-certificates/{build-certificate-slug}/uploaded")
    suspend fun buildCertificateConfirm(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("build-certificate-slug") buildCertificateSlug: String
    ): V0BuildCertificateResponseModel
    /**
     * Create a build certificate
     * Create a temporary pre-signed upload URL for the build certificate and upload the file to AWS with a simple `curl` request. To complete the uploading process and view your files on the Code Signing tab of your app, continue with the [POST /apps/{app-slug}/build-certificates/{build-certificate-slug}/uploaded](https://api-docs.bitrise.io/#/build-certificate/build-certificate-confirm) endpoint. Read more in our [Creating and uploading an iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#creating--uploading-an-ios-code-signing-file) guide.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildCertificate Build certificate parameters such as file name and its file size (required)
     */
    @Headers(
        "X-Operation-ID: build-certificate-create",
      "Content-Type: application/json"
    )
    @POST("apps/{app-slug}/build-certificates")
    suspend fun buildCertificateCreate(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Body buildCertificate: V0BuildCertificateUploadParams
    ): V0BuildCertificateResponseModel
    /**
     * Delete a build certificate
     * Delete an app's build certificate. You can fetch the build certificate slug for this endpoint if you first call the [GET /apps/{app-slug}/build-certificates](https://api-docs.bitrise.io/#/build-certificate/build-certificate-list) endpoint to list all available build certificates of an app. Read more in our [Deleting an iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#deleting-an-ios-code-signing-file) guide.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildCertificateSlug Build certificate slug (required)
     */
    @Headers(
        "X-Operation-ID: build-certificate-delete"
    )
    @DELETE("apps/{app-slug}/build-certificates/{build-certificate-slug}")
    suspend fun buildCertificateDelete(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("build-certificate-slug") buildCertificateSlug: String
    ): V0BuildCertificateResponseModel
    /**
     * Get a list of the build certificates
     * List all the build certificates that have been uploaded to a specific app. Read more in our [Listing the uploaded iOS code signing files of an app](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#listing-the-uploaded-ios-code-signing-files-of-an-app) guide.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param next Slug of the first build certificate in the response (optional)
     * @param limit Max number of build certificates per page is 50. (optional)
     */
    @Headers(
        "X-Operation-ID: build-certificate-list"
    )
    @GET("apps/{app-slug}/build-certificates")
    suspend fun buildCertificateList(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Query("next") next: String?,
        @retrofit2.http.Query("limit") limit: Int?
    ): V0BuildCertificateListResponseModel
    /**
     * Get a specific build certificate
     * Retrieve data of a specific build certificate. You can fetch the build certificate slug for this endpoint if you first call the [GET /apps/{app-slug}/build-certificates](https://api-docs.bitrise.io/#/build-certificate/build-certificate-list) endpoint to list all available build certificates of an app. Read more in our [Getting a specific iOS code signing file's data](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#getting-a-specific-ios-code-signing-files-data) guide.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildCertificateSlug Build certificate slug (required)
     */
    @Headers(
        "X-Operation-ID: build-certificate-show"
    )
    @GET("apps/{app-slug}/build-certificates/{build-certificate-slug}")
    suspend fun buildCertificateShow(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("build-certificate-slug") buildCertificateSlug: String
    ): V0BuildCertificateResponseModel
    /**
     * Update a build certificate
     * Update an uploaded build certificate's attributes. You can fetch the build certificate slug for this endpoint if you first call the [GET /apps/{app-slug}/build-certificates](https://api-docs.bitrise.io/#/build-certificate/build-certificate-list) endpoint. Read more in our [Updating an uploaded iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#confirming-the-ios-code-signing-file-upload) guide.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param buildCertificateSlug Build certificate slug (required)
     * @param buildCertificate Build certificate parameters (required)
     */
    @Headers(
        "X-Operation-ID: build-certificate-update",
      "Content-Type: application/json"
    )
    @PATCH("apps/{app-slug}/build-certificates/{build-certificate-slug}")
    suspend fun buildCertificateUpdate(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Path("build-certificate-slug") buildCertificateSlug: String,
        @retrofit2.http.Body buildCertificate: V0BuildCertificateUpdateParams
    ): V0BuildCertificateResponseModel
}

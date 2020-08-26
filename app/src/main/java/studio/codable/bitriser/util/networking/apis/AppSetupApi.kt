/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Bitrise API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package studio.codable.bitriser.util.networking.apis

import retrofit2.http.Headers
import retrofit2.http.POST
import studio.codable.bitriser.util.networking.models.ServiceStandardErrorRespModel
import studio.codable.bitriser.util.networking.models.V0AppConfigRequestParam
import studio.codable.bitriser.util.networking.models.V0AppConfigRespModel
import studio.codable.bitriser.util.networking.models.V0AppFinishParams
import studio.codable.bitriser.util.networking.models.V0AppFinishRespModel
import studio.codable.bitriser.util.networking.models.V0AppRespModel
import studio.codable.bitriser.util.networking.models.V0AppUploadParams
import studio.codable.bitriser.util.networking.models.V0SSHKeyRespModel
import studio.codable.bitriser.util.networking.models.V0SSHKeyUploadParams
import studio.codable.bitriser.util.networking.models.V0WebhookRespModel

@JvmSuppressWildcards
interface AppSetupApi {
    /**
     * Upload a new bitrise.yml for your application.
     * Upload a new bitrise.yml for your application.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param appConfig App config parameters (required)
     */
    @Headers(
        "X-Operation-ID: app-config-create",
      "Content-Type: application/json"
    )
    @POST("apps/{app-slug}/bitrise.yml")
    suspend fun appConfigCreate(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Body appConfig: V0AppConfigRequestParam
    ): V0AppConfigRespModel
    /**
     * Add a new app
     * Add a new app to Bitrise. This is the first step of the app registration process. To successfully set it up, you need to provide the required app parameters: your git provider, the repository URL, the slug of the repository as it appears at the provider, and the slug of the owner of the repository. Read more about the app creation process in our [detailed guide](https://devcenter.bitrise.io/api/adding-and-managing-apps/#adding-a-new-app).
     * The endpoint is owned by defaultname service owner
     * @param app App parameters (required)
     */
    @Headers(
        "X-Operation-ID: app-create",
      "Content-Type: application/json"
    )
    @POST("apps/register")
    suspend fun appCreate(
        @retrofit2.http.Body app: V0AppUploadParams
    ): V0AppRespModel
    /**
     * Save the application at the end of the app registration process
     * Save the application after registering it on Bitrise and registering an SSH key (and, optionally, adding a webhook). With this endpoint you can define the initial configuration, define application-level environment variables, determine the project type, and set an Organization to be the owner of the app. Read more about the app registration process in our [detailed guide](https://devcenter.bitrise.io/api/adding-and-managing-apps/#adding-a-new-app).
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param app App finish parameters (required)
     */
    @Headers(
        "X-Operation-ID: app-finish",
      "Content-Type: application/json"
    )
    @POST("apps/{app-slug}/finish")
    suspend fun appFinish(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Body app: V0AppFinishParams
    ): V0AppFinishRespModel
    /**
     * Register an incoming webhook for a specific application
     * [Register an incoming webhook](https://devcenter.bitrise.io/api/incoming-and-outgoing-webhooks/#incoming-webhooks) for a specific application. You can do this during the app registration process or at any other time in an app's life. When calling this endpoint, a webhook is registered at your git provider: this is necessary to automatically trigger builds on Bitrise.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     */
    @Headers(
        "X-Operation-ID: app-webhook-create",
      "Content-Type: application/json"
    )
    @POST("apps/{app-slug}/register-webhook")
    suspend fun appWebhookCreate(
        @retrofit2.http.Path("app-slug") appSlug: String
    ): V0WebhookRespModel
    /**
     * Add an SSH-key to a specific app
     * Add an SSH-key to a specific app. After creating an app, you need to register the SSH key so that Bitrise will be able to access and clone your repository during the build process. This requires the app slug of your newly created app.
     * The endpoint is owned by defaultname service owner
     * @param appSlug App slug (required)
     * @param sshKey SSH key parameters (required)
     */
    @Headers(
        "X-Operation-ID: ssh-key-create",
      "Content-Type: application/json"
    )
    @POST("apps/{app-slug}/register-ssh-key")
    suspend fun sshKeyCreate(
        @retrofit2.http.Path("app-slug") appSlug: String,
        @retrofit2.http.Body sshKey: V0SSHKeyUploadParams
    ): V0SSHKeyRespModel
}
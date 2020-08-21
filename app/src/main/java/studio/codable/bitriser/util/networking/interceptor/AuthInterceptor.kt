package studio.codable.bitriser.util.networking.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import studio.codable.bitriser.BuildConfig

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val updatedRequest = chain.request().newBuilder().addHeader("Authorization", BuildConfig.PERSONAL_ACCESS_TOKEN).build()
        return chain.proceed(updatedRequest)
    }
}
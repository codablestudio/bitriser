package studio.codable.bitriser.util.networking

import studio.codable.bitriser.util.errorHandling.DisplayableError

sealed class NetworkResult<out T> {
    data class Success<out T>(val value: T) : NetworkResult<T>()
    data class Error(
        override val causedBy: Throwable?, override val code: Int?,
        override val message: String?
    ) : NetworkResult<Nothing>(), DisplayableError {
        override fun extractStringToDisplay(): String? {
            return when {
                message != null -> message
                code != null -> code.toString()
                causedBy?.message != null -> causedBy.message.toString()
                else -> null
            }
        }
    }
}
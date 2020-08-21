package studio.codable.bitriser.util.networking

import studio.codable.bitriser.util.errorHandling.DisplayableError

sealed class NetworkResult<out T> {
    data class Success<out T>(val value: T) : NetworkResult<T>()
    sealed class Error : NetworkResult<Nothing>(), DisplayableError {

        data class Http(
            override val causedBy: Throwable, override val code: Int,
            override val message: String
        ) : Error() {
            override fun extractStringToDisplay(): String = "$code: $message"
        }

        data class IO(override val causedBy: Throwable) : Error() {
            override val code: Int? = null
            override val message: String? = null
            override fun extractStringToDisplay(): String? = causedBy.message
        }

        data class JsonParsing(override val causedBy: Throwable) : Error() {
            override val code: Int? = null
            override val message: String? = null
            override fun extractStringToDisplay(): String? = causedBy.message
        }

        data class Unknown(override val causedBy: Throwable) : Error() {
            override val code: Int? = null
            override val message: String? = null
            override fun extractStringToDisplay(): String? =
                "Unrecognized error happened: '${causedBy.message}'"
        }
    }
}
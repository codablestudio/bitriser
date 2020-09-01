package studio.codable.bitriser.base

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import studio.codable.bitriser.util.networking.NetworkResult
import studio.codable.bitriser.util.networking.api.ErrorResponseModel
import timber.log.Timber
import java.io.IOException

abstract class BaseRepository {

    protected inline infix fun <T, R> NetworkResult<T>.process(onSuccess: (data: T) -> R): NetworkResult<R> {
        return when (this) {
            is NetworkResult.Success -> NetworkResult.Success(onSuccess(this.value))
            is NetworkResult.Error -> this
        }
    }

    protected suspend inline fun <T> callApi(crossinline apiCall: suspend () -> T): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                val result = NetworkResult.Success(apiCall())
                Timber.i("Successful HTTPS request: $result")
                result
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> {
                        val networkResult =
                            NetworkResult.Error.IO(throwable) as NetworkResult<Nothing>
                        networkResult
                    }
                    is HttpException -> NetworkResult.Error.Http(
                        throwable,
                        throwable.code(),
                        convertErrorBody(throwable)?.message.orEmpty()
                    )
                    is JsonDataException -> NetworkResult.Error.JsonParsing(throwable)
                    else -> NetworkResult.Error.Unknown(throwable)

                }
            }
        }
    }

    fun convertErrorBody(throwable: HttpException): ErrorResponseModel? {
        return try {
            throwable.response()?.errorBody()?.source()?.let {
                Timber.d("Converting error body: $it")
                val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponseModel::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (e: Exception) {
            Timber.e(e, "Cannot convert error body: $throwable")
            null
        }
    }
}
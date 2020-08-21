package studio.codable.bitriser.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import studio.codable.bitriser.util.Event
import studio.codable.bitriser.util.errorHandling.DisplayableError
import studio.codable.bitriser.util.networking.NetworkResult

abstract class BaseViewModel : ViewModel() {
    private val _errors = MutableLiveData<Event<DisplayableError>>()
    val errors: LiveData<Event<DisplayableError>> = _errors

    protected val _loading = MediatorLiveData<Event<Boolean>>().apply {
        addSource(_errors) {
            this.value = Event(false)
        }
    }
    val loading: LiveData<Event<Boolean>> = _loading

    protected open fun setError(error: DisplayableError) {
        _errors.value = Event(error)
    }

    protected open fun setLoading(enabled: Boolean) {
        _loading.value = Event(enabled)
    }

    protected inline fun <T> NetworkResult<T>.process(onSuccess: (value: T) -> Unit){
        when(this){
            is NetworkResult.Success -> {
                _loading.value = Event(false)
                onSuccess(this.value)
            }
            is NetworkResult.Error -> setError(this)
        }
    }
}
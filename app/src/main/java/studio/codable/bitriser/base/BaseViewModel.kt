package studio.codable.bitriser.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import studio.codable.bitriser.util.Event
import studio.codable.bitriser.util.errorHandling.DisplayableError

abstract class BaseViewModel : ViewModel() {
    private val _errors = MutableLiveData<Event<DisplayableError>>()
    val errors: LiveData<Event<DisplayableError>> = _errors

    private val _loading = MediatorLiveData<Event<Boolean>>().apply {
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
}
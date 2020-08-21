package studio.codable.bitriser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import studio.codable.bitriser.base.BaseViewModel
import studio.codable.bitriser.util.networking.api.application.model.request.GetAppsRequest
import studio.codable.bitriser.util.repository.IApplicationRepository

class MainViewModel(private val applicationRepository: IApplicationRepository) : BaseViewModel() {

    private val _apps = MutableLiveData<Unit>()
    val apps: LiveData<Unit> = _apps

    fun test() {
        viewModelScope.launch {
            applicationRepository.getApps(GetAppsRequest.SortOrder.CREATED_AT).process {
                _apps.value = Unit
            }
        }
    }
}
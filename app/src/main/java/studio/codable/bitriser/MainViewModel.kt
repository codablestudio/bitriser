package studio.codable.bitriser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import studio.codable.bitriser.base.BaseViewModel
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AppItemResponse
import studio.codable.bitriser.util.repository.IApplicationRepository

class MainViewModel(private val applicationRepository: IApplicationRepository) : BaseViewModel() {

    private val _apps = MutableLiveData<List<AppItemResponse>>()
    val apps: LiveData<List<AppItemResponse>> = _apps

    fun test() {
        viewModelScope.launch {
            applicationRepository.getApps().process {
                _apps.value = it
            }
        }
    }
}
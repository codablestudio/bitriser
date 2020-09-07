package studio.codable.bitriser

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import studio.codable.bitriser.base.BaseViewModel
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.model.BuildInfo
import studio.codable.bitriser.util.repository.application.IApplicationRepository
import studio.codable.bitriser.util.repository.builds.BuildsRepository
import studio.codable.bitriser.util.repository.builds.IBuildsRepository

class MainViewModel(private val applicationRepository: IApplicationRepository, private val buildsRepository: IBuildsRepository) : BaseViewModel() {

    private val _apps = MutableLiveData<List<AppInfo>>()
    val apps: LiveData<List<AppInfo>> = _apps

    var builds: List<BuildInfo> by mutableStateOf(listOf())
        private set

    fun getApps() {
        viewModelScope.launch {
            applicationRepository.getApps().process {
                _apps.value = it
            }
        }
    }

    fun getBuilds() {
        viewModelScope.launch {
            buildsRepository.getBuilds().process {
                builds = it
            }
        }
    }
}
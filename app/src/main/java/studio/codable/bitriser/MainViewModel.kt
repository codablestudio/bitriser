package studio.codable.bitriser

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import studio.codable.bitriser.base.BaseViewModel
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.model.BuildInfo
import studio.codable.bitriser.util.Event
import studio.codable.bitriser.util.errorHandling.EmptyDisplayableError
import studio.codable.bitriser.util.repository.application.IApplicationRepository
import studio.codable.bitriser.util.repository.builds.IBuildsRepository

class MainViewModel(
    private val applicationRepository: IApplicationRepository,
    private val buildsRepository: IBuildsRepository
) : BaseViewModel() {

    var apps: List<AppInfo> by mutableStateOf(listOf())
        private set

    var builds: List<BuildInfo> by mutableStateOf(listOf())
        private set

    fun getApps() {
        viewModelScope.launch {
            applicationRepository.getApps().process {
                apps = it
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

    fun postError() {
        val error = EmptyDisplayableError("This is an error")

        _errors.value = Event(error)
    }
}
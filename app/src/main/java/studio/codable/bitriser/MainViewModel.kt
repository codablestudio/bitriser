package studio.codable.bitriser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import studio.codable.bitriser.util.repository.IApplicationRepository

class MainViewModel(private val applicationRepository: IApplicationRepository) : ViewModel() {

    fun test() {
        viewModelScope.launch {
            applicationRepository.getApps()
        }
    }
}
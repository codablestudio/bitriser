package studio.codable.bitriser

import androidx.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel(private val string:String) : ViewModel() {

    fun test(){
        Timber.d(string)
    }
}
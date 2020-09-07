package studio.codable.bitriser

import android.os.Bundle
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.LiveData
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler
import com.github.zsoltk.compose.router.Router
import org.koin.android.viewmodel.ext.android.viewModel
import studio.codable.bitriser.base.BaseActivity
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.view.Routing
import studio.codable.bitriser.view.application.ApplicationDetailsFragment
import studio.codable.bitriser.view.builds.BuildListScreen
import studio.codable.bitriser.view.custom.AppList
import studio.codable.bitriser.view.custom.LiveDataAppItemsList
import timber.log.Timber

class MainActivity : BaseActivity() {

    companion object {
        @Composable
        fun Content(liveData: LiveData<List<AppInfo>>, onItemClick: (AppInfo) -> Unit) {
            LiveDataAppItemsList(liveData = liveData) {
                AppList(appList = it, onItemClick)
            }
        }
    }

    private val vm: MainViewModel by viewModel()

    private val backPressHandler = BackPressHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Providers(AmbientBackPressHandler provides backPressHandler) {
                MainActivityContent(
                    defaultRouting = Routing.BuildList,
                    vm = vm
                )
            }
        }

        vm.errors.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                Timber.e(it.toString())
                Toast.makeText(this, it.extractStringToDisplay(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        if (!backPressHandler.handle()) {
            super.onBackPressed()
        }
    }
}

@Composable
fun MainActivityContent(
    defaultRouting: Routing,
    vm: MainViewModel
) {
    Router("BuildList", defaultRouting) { backStack ->
        when (val routing = backStack.last()) {
            is Routing.AppList -> {
                vm.getApps()
                MainActivity.Content(liveData = vm.apps) {
                    backStack.push(Routing.AppDetails(it))
                }
            }

            is Routing.BuildList -> {
                vm.getBuilds()
                BuildListScreen.Content(
                    builds = vm.builds
                )
            }

            is Routing.AppDetails -> {
                ApplicationDetailsFragment.Content(
                    appInfo = routing.appInfo
                )
            }
        }
    }
}
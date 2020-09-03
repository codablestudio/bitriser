package studio.codable.bitriser

import android.os.Bundle
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.platform.setContent
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler
import com.github.zsoltk.compose.router.Router
import org.koin.android.viewmodel.ext.android.viewModel
import studio.codable.bitriser.base.BaseActivity
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.view.Routing
import studio.codable.bitriser.view.application.ApplicationDetailsFragment
import studio.codable.bitriser.view.custom.LiveDataAppItemsList
import timber.log.Timber

class MainActivity : BaseActivity() {

    companion object {
        @Composable
        fun Content(vm: MainViewModel, onItemClick: (AppInfo) -> Unit) {
            LiveDataAppItemsList(liveData = vm.apps, onItemClick = onItemClick)
        }
    }

    private val vm: MainViewModel by viewModel()

    private val backPressHandler = BackPressHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Providers(AmbientBackPressHandler provides backPressHandler) {
                MainActivityContent(
                    defaultRouting = Routing.AppList,
                    vm = vm
                )
            }
        }

        vm.test()

        vm.errors.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                Timber.d(it.toString())
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
    Router("AppList", defaultRouting) { backStack ->
        when (val routing = backStack.last()) {
            is Routing.AppList -> {
                MainActivity.Content(vm = vm) {
                    backStack.push(Routing.AppDetails(it))
                }
            }

            is Routing.AppDetails -> {
                ApplicationDetailsFragment.Content(
                    appInfo = routing.appInfo
                )
            }
        }
    }
}
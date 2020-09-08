package studio.codable.bitriser

import android.os.Bundle
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Tab
import androidx.compose.material.TabConstants
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.material.TabRow
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler
import com.github.zsoltk.compose.router.BackStack
import com.github.zsoltk.compose.router.Router
import org.koin.android.viewmodel.ext.android.viewModel
import studio.codable.bitriser.base.BaseActivity
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.view.Routing
import studio.codable.bitriser.view.application.ApplicationDetailsFragment
import studio.codable.bitriser.view.custom.AppList
import studio.codable.bitriser.view.custom.BuildList
import studio.codable.bitriser.view.custom.LoaderUntilLoaded
import studio.codable.bitriser.view.custom.showError

class MainActivity : BaseActivity() {

//    companion object {
//        @Composable
//        fun Content(liveData: LiveData<List<AppInfo>>, onItemClick: (AppInfo) -> Unit) {
//            LiveDataAppItemsList(liveData = liveData) {
//                AppList(appList = it, onItemClick)
//            }
//        }
//    }

    private val vm: MainViewModel by viewModel()

    private val backPressHandler = BackPressHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Providers(AmbientBackPressHandler provides backPressHandler) {
                MainActivityContent(
                    defaultRouting = Routing.HomeScreen,
                    vm = vm
                )
            }
        }

//        vm.errors.observe(this) { event ->
//            event.getContentIfNotHandled()?.let {
//                Timber.e(it.toString())
//                Toast.makeText(this, it.extractStringToDisplay(), Toast.LENGTH_SHORT).show()
//            }
//        }
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
            is Routing.HomeScreen -> {
                MainContent(backStack = backStack, vm = vm)
            }

            is Routing.AppDetails -> {
                ApplicationDetailsFragment.Content(
                    appInfo = routing.appInfo
                )
            }
        }
    }
}

@Composable
private fun MainContent(
    backStack: BackStack<Routing>,
    vm: MainViewModel
) {
    vm.errors.observeAsState().value?.getContentIfNotHandled()?.let {
        showError(error = it)
    }

    when (val routing = backStack.last()) {
        is Routing.HomeScreen -> {
            Column {
                Tabs(0, vm, backStack)
                Button(onClick = vm::postError) {
                    Text(text = "show error")
                }
            }
        }

        is Routing.AppDetails -> {
            OpenAppDetails(routing.appInfo)
        }
    }
}

@Composable
private fun OpenAppDetails(appInfo: AppInfo) {
    ApplicationDetailsFragment.Content(
        appInfo = appInfo
    )
}

@Composable
private fun Tabs(defaultSelectedIndex: Int = 0, vm: MainViewModel, backStack: BackStack<Routing>) {
    var state by remember { mutableStateOf(defaultSelectedIndex) }

    val tabItems = listOf(
        TabItem("Apps") {
            LoaderUntilLoaded(vm.apps) { apps ->
                AppList(apps = apps) {
                    backStack.push(Routing.AppDetails(it))
                }
            }
        },
        TabItem("Builds") {
            LoaderUntilLoaded(itemList = vm.builds) { builds ->
                BuildList(builds = builds) {

                }
            }
        }
    )

    Column {
        TabRow(selectedTabIndex = state, indicator = { tabPositions ->
            TabConstants.DefaultIndicator(
                Modifier.defaultTabIndicatorOffset(tabPositions[state])
            )
        }) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = tabItem.title) })
            }
        }

        when (state) {
            0 -> vm.getApps()
            1 -> vm.getBuilds()
        }

        tabItems[state].composable()
    }
}

data class TabItem(val title: String, val composable: @Composable() () -> Unit)
package studio.codable.bitriser

import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.Box
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabConstants
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.material.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.onPositioned
import androidx.compose.ui.platform.DensityAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.github.zsoltk.compose.backpress.AmbientBackPressHandler
import com.github.zsoltk.compose.backpress.BackPressHandler
import com.github.zsoltk.compose.router.BackStack
import com.github.zsoltk.compose.router.Router
import org.koin.android.viewmodel.ext.android.viewModel
import studio.codable.bitriser.base.BaseActivity
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.view.Routing
import studio.codable.bitriser.view.application.ApplicationDetailsFragment
import studio.codable.bitriser.view.custom.AppItem
import studio.codable.bitriser.view.custom.BuildItem
import studio.codable.bitriser.view.custom.ListWithDividers
import studio.codable.bitriser.view.custom.LoaderUntilLoaded
import timber.log.Timber
import kotlin.math.abs

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
    when (val routing = backStack.last()) {
        is Routing.HomeScreen -> {
            Tabs(0, vm, backStack)
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
    var selectedTabIndex by remember { mutableStateOf(defaultSelectedIndex) }

    WithConstraints(modifier = Modifier.padding(20.dp)) {
        val boxWidthPx = constraints.maxWidth
        val boxWidthDp = with(DensityAmbient.current) { boxWidthPx.toDp() }
        val tabWidthModifier = Modifier.preferredWidth(boxWidthDp)

        val tabItems = listOf(
            TabItem("Apps") {
                LoaderUntilLoaded(itemList = vm.apps) { apps ->
                    ListWithDividers(
                        modifier = tabWidthModifier.padding(8.dp),
                        itemList = apps,
                        onItemClick = {
                            backStack.push(Routing.AppDetails(it))
                        }) { modifier, _, item -> AppItem(modifier = modifier, item) }
                }
            },
            TabItem("Builds") {
                LoaderUntilLoaded(itemList = vm.builds) { builds ->
                    ListWithDividers(
                        modifier = tabWidthModifier.padding(8.dp),
                        itemList = builds,
                        onItemClick = {
                            // nothing yet
                        }) { modifier, _, item -> BuildItem(modifier = modifier, build = item) }
                }
            },
            TabItem("treci") {
                Text("treci")
            }
        )
        Column {
            TabRow(selectedTabIndex = selectedTabIndex, indicator = { tabPositions ->
                TabConstants.DefaultIndicator(
                    Modifier.defaultTabIndicatorOffset(tabPositions[selectedTabIndex])
                )
            }) {
                tabItems.forEachIndexed { index, tabItem ->
                    Tab(
                        modifier = Modifier.fillMaxWidth(),
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(text = tabItem.title) })
                }
            }

            when (selectedTabIndex) {
                0 -> vm.getApps()
                1 -> vm.getBuilds()
            }

//        val scrollController = rememberScrollableController(consumeScrollDelta = { it/20 })

//            val context = ContextAmbient.current
//            val resources = context.resources
//            val displayMetrics = resources.displayMetrics
//            val screenWidth = displayMetrics.widthPixels / displayMetrics.density

            fun determineSelectedTabIndex(position: Offset): Int {
                var calculatedIndex = (abs(position.x) / boxWidthPx).toInt()

                val positionFromZero = abs(position.x) - selectedTabIndex * boxWidthPx

                if (positionFromZero > 2 * boxWidthPx / 3) {
                    calculatedIndex++
                }

                return if (calculatedIndex <= tabItems.size - 1) calculatedIndex else tabItems.size - 1
            }

            ScrollableRow(
                modifier = tabWidthModifier
//                .scrollable(
//                    orientation = Orientation.Horizontal,
//                    controller = scrollController
//                )
                    .onPositioned { layoutCoordinates ->
                        val position = layoutCoordinates.positionInParent
                        Timber.d("Position: $position, boxWidth: $boxWidthPx")

                        selectedTabIndex = determineSelectedTabIndex(position)
                    }
            ) {
                Row {
                    tabItems.forEach {
                        Box(modifier = tabWidthModifier) { it.composable() }
                    }
                }
            }
        }
    }
}

data class TabItem(val title: String, val composable: @Composable() () -> Unit)
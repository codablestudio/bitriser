package studio.codable.bitriser

import android.os.Bundle
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.gesture.scrollorientationlocking.Orientation
import androidx.compose.ui.graphics.Color
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
import studio.codable.bitriser.model.BuildInfo
import studio.codable.bitriser.view.Routing
import studio.codable.bitriser.view.application.ApplicationDetailsFragment
import studio.codable.bitriser.view.custom.*

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

        vm.getApps()
        vm.getBuilds()

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
            val bottomDrawerState =
                rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)

            var selectedBuild: BuildInfo? by remember { mutableStateOf(null) }

            val tabItems = listOf(
                TabItem("Apps") { modifier ->
                    Surface(color = Color.Magenta) {
                        LoaderUntilLoaded(itemList = vm.apps) { apps ->
                            ListWithDividers(
                                modifier = modifier.padding(8.dp),
                                itemList = apps,
                                onItemClick = {
                                    backStack.push(Routing.AppDetails(it))
                                }) { modifier, _, item -> AppItem(modifier = modifier, item) }
                        }
                    }
                },
                TabItem("Builds") { modifier ->
                    Surface(color = Color.Red) {
                        LoaderUntilLoaded(itemList = vm.builds) { builds ->
                            ListWithDividers(
                                modifier = modifier.padding(8.dp),
                                itemList = builds,
                                onItemClick = {
                                    selectedBuild = it
                                    bottomDrawerState.open()
                                }) { modifier, _, item ->
                                BuildItem(
                                    modifier = modifier,
                                    build = item
                                )
                            }
                        }
                    }
                },
                TabItem("treci") {
                    Surface(color = Color.Yellow) {
                        Text("treci")
                    }
                }
            )

            BottomDrawerLayout(
                drawerState = bottomDrawerState,
                gesturesEnabled = bottomDrawerState.isOpen,
                drawerContent = {
                    BuildDetails(selectedBuild = selectedBuild)
                }) { HomeScreenContent(vm = vm, tabItems = tabItems) }
        }

        is Routing.AppDetails -> {
            OpenAppDetails(routing.appInfo)
        }
    }
}

@Composable
fun HomeScreenContent(vm: MainViewModel, tabItems: List<TabItem>) {

    Surface(color = Color.Blue) {
        Column {
            Tabs(0, vm, tabItems)

            Divider(color = Color.Green, thickness = 4.dp)

            Surface(color = Color.Yellow) {
                Button(onClick = vm::postError) {
                    Text(text = "show error")
                }
            }

            Divider(color = Color.Green, thickness = 4.dp)
        }
    }
}

@Composable
fun BuildDetails(selectedBuild: BuildInfo?) {
    selectedBuild?.let {
        Text(text = it.triggeredAt.toString())
    }
}

@Composable
private fun OpenAppDetails(appInfo: AppInfo) {
    ApplicationDetailsFragment.Content(
        appInfo = appInfo
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Tabs(defaultSelectedIndex: Int = 0, vm: MainViewModel, tabItems: List<TabItem>) {
    var selectedTabIndex by remember { mutableStateOf(defaultSelectedIndex) }
    val swipeableState = rememberSwipeableState(initialValue = defaultSelectedIndex)
    selectedTabIndex = swipeableState.value

    WithConstraints(
        modifier = Modifier.padding(
            start = 20.dp,
            end = 20.dp,
            top = 20.dp,
            bottom = 60.dp
        )
    ) {
        Surface(color = Color.Cyan) {
            val boxWidthPx = constraints.maxWidth
            val boxWidthDp = with(DensityAmbient.current) { boxWidthPx.toDp() }
            val tabWidthModifier = Modifier.preferredWidth(boxWidthDp)

            val anchors = hashMapOf<Float, Int>()
            tabItems.indices.forEach {
                anchors[-it * boxWidthPx.toFloat()] = it
            }

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
                            onClick = {
                                selectedTabIndex = index
                                swipeableState.snapTo(index)
                            },
                            text = { Text(text = tabItem.title) })
                    }
                }

//                when (selectedTabIndex) {
//                    0 -> vm.getApps()
//                    1 -> vm.getBuilds()
//                }

                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .swipeable(
                            state = swipeableState,
                            anchors = anchors,
                            thresholds = { _, _ -> FractionalThreshold(0.5f) },
                            orientation = Orientation.Horizontal
                        )
                ) {
                    Row(
                        modifier = Modifier.wrapContentSize().offsetPx(x = swipeableState.offset)
                    ) { tabItems.forEach { it.composable(tabWidthModifier.fillMaxHeight()) } }
                }
            }
        }
    }
}

data class TabItem(
    val title: String,
    val composable: @Composable() (modifier: Modifier) -> Unit
)
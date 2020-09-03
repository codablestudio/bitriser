package studio.codable.bitriser.view.custom

import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.model.OwnerAccount

@Preview
@Composable
fun AppListPreview() {
    AppList(
        listOf(
            AppInfo(
                "",
                isDisabled = false,
                isPublic = true,
                OwnerAccount("", "Filip", ""),
                "project type",
                "provider",
                "MrPranklin",
                "",
                "github/mrpranklin",
                "",
                1,
                "App title"
            ), AppInfo(
                "",
                isDisabled = false,
                isPublic = true,
                OwnerAccount("", "Filip", ""),
                "project type",
                "provider",
                "MrPranklin",
                "",
                "github/mrpranklin",
                "",
                1,
                "App title"
            )
        )
    ){}
}

@Composable
fun AppList(appList: List<AppInfo>, onItemClick: (AppInfo) -> Unit) {
    LazyColumnForIndexed(items = appList) { index, appInfo ->
        AppItem(appInfo = appInfo, onItemClick)
        if (index != appList.size - 1) {
            Divider(color = MaterialTheme.colors.primary)
        }
    }
}
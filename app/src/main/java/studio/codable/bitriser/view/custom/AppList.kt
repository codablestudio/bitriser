package studio.codable.bitriser.view.custom

import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import studio.codable.bitriser.model.AppInfo
import studio.codable.bitriser.model.OwnerAccount

@Composable
fun AppList(apps: List<AppInfo>, onItemClick: (AppInfo) -> Unit) {
    LazyColumnForIndexed(items = apps) { index, appInfo ->
        AppItem(appInfo = appInfo, onItemClick)
        if (index != apps.size - 1) {
            Divider(color = MaterialTheme.colors.primary)
        }
    }
}
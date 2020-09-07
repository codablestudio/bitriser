package studio.codable.bitriser.view.custom

import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import studio.codable.bitriser.model.BuildInfo

@Composable
fun BuildList(builds: List<BuildInfo>, onItemClick: (BuildInfo) -> Unit) {
    LazyColumnForIndexed(items = builds) { index, build ->
        BuildItem(onItemClick, build)
        if (index != builds.size - 1) {
            Divider(color = MaterialTheme.colors.primary)
        }
    }
}
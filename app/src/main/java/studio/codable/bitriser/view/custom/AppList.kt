package studio.codable.bitriser.view.custom

import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AccountOwnerResponse
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AppItemResponse

@Preview
@Composable
fun AppListPreview() {
    AppList(
        listOf(
            AppItemResponse(
                "",
                isDisabled = false,
                isPublic = true,
                AccountOwnerResponse("", "Filip", ""),
                "project type",
                "provider",
                "MrPranklin",
                "",
                "github/mrpranklin",
                "",
                1,
                "App title"
            ), AppItemResponse(
                "",
                isDisabled = false,
                isPublic = true,
                AccountOwnerResponse("", "Filip", ""),
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
    )
}

@Composable
fun AppList(appList: List<AppItemResponse>) {
    LazyColumnForIndexed(items = appList) { index, appItem ->
        AppItem(appData = appItem)
        if (index != appList.size - 1) {
            Divider(color = MaterialTheme.colors.primary)
        }
    }
}
package studio.codable.bitriser.view.custom

import androidx.compose.runtime.Composable

@Composable
fun <T> LoaderUntilLoaded(itemList: List<T>, onLoaded: @Composable() (itemList: List<T>) -> Unit) {
    if (itemList.isEmpty()) {
        Loader()
    } else {
        onLoaded(itemList)
    }
}

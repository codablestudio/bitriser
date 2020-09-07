package studio.codable.bitriser.view.custom

import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.ui.tooling.preview.Preview

@Composable
fun <T> LiveDataAppItemsList(
    liveData: LiveData<List<T>>,
    onLoaded: @Composable() (itemList: List<T>) -> Unit
) {
    val items by liveData.observeAsState(emptyList())

    if (items.isEmpty()) {
        Loader()
    } else {
        onLoaded(liveData.value!!)
    }
}

@Preview("loader")
@Composable
fun Loader() {
    Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center) {
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(CenterHorizontally))
    }
}
package studio.codable.bitriser.view.custom

import android.view.MenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageAsset

@Composable
fun <T> TopAppBar(
    title: @Composable() () -> Unit,
    actionData: List<T>,
    color: Color = MaterialTheme.colors.primary,
    navigationIcon: @Composable() (() -> Unit)? = null,
    modifier: Modifier? = null,
    action: @Composable() (T) -> Unit) {
}

@Composable
fun AppBarIcon(image: @Composable() ()-> Unit, action: (MenuItem) -> Unit){

}
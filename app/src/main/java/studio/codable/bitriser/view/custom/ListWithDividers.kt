package studio.codable.bitriser.view.custom

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> ListWithDividers(
    modifier: Modifier,
    itemList: List<T>,
    onItemClick: (T) -> Unit,
    child: @Composable() (modifier: Modifier, index: Int, item: T) -> Unit
) {
    ScrollableColumn(modifier = modifier) {
        itemList.forEachIndexed { index, item ->
            child(modifier.clickable(onClick = { onItemClick(item) }), index, item)

            if (index != itemList.size - 1) {
                Divider(
                    modifier = modifier.padding(horizontal = 30.dp),
                    color = MaterialTheme.colors.primary
                )
            }
        }
    }
}
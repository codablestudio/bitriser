package studio.codable.bitriser.view.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnForIndexed
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
    LazyColumnForIndexed(modifier = modifier, items = itemList) { index, item ->
        child(modifier.clickable(onClick = { onItemClick(item) }), index, item)
        if (index != itemList.size - 1) {
            Divider(
                modifier = modifier.padding(horizontal = 30.dp),
                color = MaterialTheme.colors.primary
            )
        }
    }
}
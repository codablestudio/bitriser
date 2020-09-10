package studio.codable.bitriser.view.custom

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import studio.codable.bitriser.model.AppInfo

@Composable
fun AppItem(modifier: Modifier, appInfo: AppInfo) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)
    ) {
        ConstraintLayout(modifier) {
            val (text_appTitle, text_repoOwner, text_repoUrl) = createRefs()

            Text(
                appInfo.title.toString(),
                style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 14.sp),
                modifier = Modifier.constrainAs(text_appTitle) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })

            Text(appInfo.repoOwner.toString(), modifier = Modifier.constrainAs(text_repoOwner) {
                start.linkTo(text_appTitle.start)
                top.linkTo(text_appTitle.bottom, margin = 8.dp)
            })

            Text(appInfo.repoUrl.toString(), modifier = Modifier.constrainAs(text_repoUrl) {
                start.linkTo(text_appTitle.end, margin = 4.dp)
                top.linkTo(text_appTitle.top)
            })
        }
    }
}
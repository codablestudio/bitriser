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
import studio.codable.bitriser.model.BuildInfo

@Composable
fun BuildItem(
    modifier: Modifier,
    build: BuildInfo
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)
    ) {
        ConstraintLayout {
            val (text_prTargetBranch, text_repoOwner, text_status) = createRefs()

            Text(text = build.originalBuildParams?.branchDest.toString(),
                style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 14.sp),
                modifier = Modifier.constrainAs(text_prTargetBranch) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })

            Text(
                build.repository?.repoOwner.toString(),
                modifier = Modifier.constrainAs(text_repoOwner) {
                    start.linkTo(text_prTargetBranch.start)
                    top.linkTo(text_prTargetBranch.bottom, margin = 8.dp)
                })

            Text(build.statusText.toString(), modifier = Modifier.constrainAs(text_status) {
                start.linkTo(text_prTargetBranch.end, margin = 4.dp)
                top.linkTo(text_prTargetBranch.top)
            })
        }
    }
}

package studio.codable.bitriser.view.custom

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AccountOwnerResponse
import studio.codable.bitriser.util.networking.api.application.model.response.submodel.AppItemResponse

@Preview
@Composable
fun AppItemPreview() {
    AppItem(
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
        )
    )
}

@Composable
fun AppItem(appData: AppItemResponse) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp), shape = RoundedCornerShape(4.dp)) {
        ConstraintLayout {
            val (text_appTitle, text_repoOwner, text_repoUrl) = createRefs()

            Text(appData.title,
                style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 14.sp),
                modifier = Modifier.constrainAs(text_appTitle) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })

            Text(appData.repoOwner, modifier = Modifier.constrainAs(text_repoOwner) {
                start.linkTo(text_appTitle.start)
                top.linkTo(text_appTitle.bottom, margin = 8.dp)
            })

            Text(appData.repoUrl, modifier = Modifier.constrainAs(text_repoUrl) {
                start.linkTo(text_appTitle.end, margin = 4.dp)
                top.linkTo(text_appTitle.top)
            })
        }
    }
}
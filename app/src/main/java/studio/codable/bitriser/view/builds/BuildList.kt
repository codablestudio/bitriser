package studio.codable.bitriser.view.builds

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
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
fun BuildList(builds: List<BuildInfo>) {
    LazyColumnFor(items = builds) { build ->
        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),//.clickable(onClick = { onClick(appInfo) }),
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
}

//@Preview
//@Composable
//fun PreviewBuildList(){
//    BuildList(mockBuilds)
//}

//val mockBuilds = listOf(
//    BuildInfo(
//        null,
//        "develop",
//        105,
//        "59775a9c3ee0998b0e89258e9bb3e78311dd52bf",
//        "button swap and ui bugfix\\n\\n- swap 'Security' and padlock button functionality on wallet details screen\\r\\n\\r\\n- fix wallet policies not showing in",
//        null,
//        null,
//        "2020-08-31T08:44:40Z",
//        false,
////        null,
//        null,
//        null,
//        null,
//        null,
//        "deploy-demoRelease",
//        null,
//        null,
//        null,
//        null,
//        1,
//        "Running",
//        null,
//        Date().toString(),
//        "webhook",
//        "deploy_to_Firebase"
//    ),
//    BuildInfo(
//        null,
//        "develop",
//        105,
//        "59775a9c3ee0998b0e89258e9bb3e78311dd52bf",
//        "button swap and ui bugfix\\n\\n- swap 'Security' and padlock button functionality on wallet details screen\\r\\n\\r\\n- fix wallet policies not showing in",
//        null,
//        null,
//        "2020-08-31T08:44:40Z",
//        false,
////        null,
//        null,
//        null,
//        "deploy-demoRelease",
//        null,
//        null,
//        null,
//        null,
//        1,
//        "Running",
//        null,
//        Date().toString(),
//        "webhook",
//        "deploy_to_Firebase"
//    )
//)
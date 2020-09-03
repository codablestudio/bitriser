package studio.codable.bitriser.view.application

import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import studio.codable.bitriser.base.BaseFragment
import studio.codable.bitriser.model.AppInfo

class ApplicationDetailsFragment : BaseFragment() {

    companion object {
        @Composable
        fun Content(appInfo: AppInfo) {
            Text(text = appInfo.title.toString())
        }
    }

    @Preview
    @Composable
    override fun mainUI() {
        Text(text = "not supposed to be here")
    }

}
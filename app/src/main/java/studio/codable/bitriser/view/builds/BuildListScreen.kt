package studio.codable.bitriser.view.builds

import androidx.compose.runtime.Composable
import studio.codable.bitriser.base.BaseFragment
import studio.codable.bitriser.model.BuildInfo
import androidx.compose.runtime.State

class BuildListScreen : BaseFragment(){

    companion object {
        @Composable
        fun Content(builds: List<BuildInfo>){
            BuildList(builds)
        }
    }


    @Composable
    override fun mainUI(){

    }
}
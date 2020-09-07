package studio.codable.bitriser.view

import studio.codable.bitriser.model.AppInfo

sealed class Routing {
    object AppList : Routing()
    object BuildList : Routing()
    data class AppDetails(val appInfo: AppInfo) : Routing()
}
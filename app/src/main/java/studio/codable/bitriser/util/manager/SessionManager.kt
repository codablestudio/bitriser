package studio.codable.bitriser.util.manager

import android.content.Context
import android.content.SharedPreferences
import timber.log.Timber

class SessionManager(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("Session", Context.MODE_PRIVATE)

    fun clearData() {
        preferences.edit().clear().apply()
        Timber.d("Preferences cleared")
    }
}
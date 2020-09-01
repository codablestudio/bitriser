package studio.codable.bitriser.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import studio.codable.bitriser.di.networkingModule
import studio.codable.bitriser.di.repositoryModule
import studio.codable.bitriser.di.viewModelModule
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
//            logger(TimberLogger())
            androidContext(this@App)
            modules(viewModelModule, repositoryModule, networkingModule)
        }
    }
}
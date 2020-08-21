package studio.codable.bitriser.app

import org.koin.core.logger.KOIN_TAG
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE
import timber.log.Timber

class TimberLogger : Logger() {

    override fun log(level: Level, msg: MESSAGE) {
        when(level){
            Level.DEBUG -> Timber.tag(KOIN_TAG).d(msg)
            Level.ERROR -> Timber.tag(KOIN_TAG).e(msg)
            Level.INFO -> Timber.tag(KOIN_TAG).i(msg)
            Level.NONE -> Timber.tag(KOIN_TAG).w(msg)
        }
    }
}
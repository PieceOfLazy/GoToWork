package piece.of.lazy.gotowork.base

import android.app.Application
import piece.of.lazy.ui.util.Log

/**
 * Created by zpdl
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.level = Log.LEVEL.DEBUG
        Log.prefix = "Lazy:"

        Log.d("GoToWork", "Application : onCreate")
    }

    override fun onTerminate() {
        super.onTerminate()

        Log.d("GoToWork", "Application : onTerminate")
    }
}
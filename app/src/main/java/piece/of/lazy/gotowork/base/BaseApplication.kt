package piece.of.lazy.gotowork.base

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import piece.of.lazy.gotowork.di.DaggerAppComponent
import piece.of.lazy.ui.util.Log

/**
 * @author piece.of.lazy
 */
class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        Log.level = Log.LEVEL.DEBUG
        Log.prefix = "Lazy:"

        Log.v("GoToWork", "Application : onCreate")
    }

    override fun onTerminate() {
        super.onTerminate()

        Log.v("GoToWork", "Application : onTerminate")
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}
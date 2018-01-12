package piece.of.lazy.gotowork.base

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import piece.of.lazy.gotowork.auth.LazyAuth
import piece.of.lazy.gotowork.di.DaggerAppComponent
import piece.of.lazy.gotowork.firebase.FbAuth
import piece.of.lazy.ui.util.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class BaseApplication : DaggerApplication() {

    @Inject
    lateinit var fbAuth: FbAuth

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

    fun getLazyAuth(): LazyAuth {
        return fbAuth
    }
}
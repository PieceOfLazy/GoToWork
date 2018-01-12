package piece.of.lazy.gotowork.app

import android.content.res.Configuration
import android.os.Bundle
import piece.of.lazy.gotowork.auth.LazyUser
import piece.of.lazy.gotowork.base.BaseActivity
import piece.of.lazy.gotowork.firebase.FbAuth
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class SplashActivity : BaseActivity<SplashFragment, SplashContract.Presenter>(), SplashContract.ActivityListener {

    @Inject
    lateinit var auth: FbAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        log.i("onCreate")

        fragmentManager?.let {
            var fragment = it.findFragmentByTag(SplashFragment::class.simpleName)
            if(fragment == null) {
                val transaction = it.beginTransaction()
                if(transaction != null) {
                    val tag = SplashFragment::class.simpleName
                    fragment = this@SplashActivity.fragment
                    transaction.replace(R.id.activity_base_fragment, fragment, tag).commit()
                }
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        SplashFragment::class.simpleName?.let {
            fragmentRefresh(it)
        }
    }

    override fun onInjected() {
        log.i("onInjected "+this)
    }

    fun getCurrentUser(): LazyUser? {
        return auth.currentUser()
    }
}

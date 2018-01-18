package piece.of.lazy.gotowork.app

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import piece.of.lazy.gotowork.R
import piece.of.lazy.gotowork.app.animation.AnimationActivity
import piece.of.lazy.gotowork.auth.LazyUser
import piece.of.lazy.gotowork.base.BaseActivity
import piece.of.lazy.gotowork.base.BaseApplication
import piece.of.lazy.gotowork.firebase.FbAuth
import piece.of.lazy.gotowork.firebase.OnFbAuthCompleteListener
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        auth.signInActivityResult(this, requestCode, resultCode, data, object : OnFbAuthCompleteListener {
            override fun onStart() {
                onLoadingStart()
            }

            override fun onComplete(Immediately: Boolean, user: LazyUser?) {
                onLoadingEnd()
                if(user == null) {
                    onShowToast("로그인에 실패하였습니다.")
                } else {
                    onShowToast("로그인에 성공하였습니다.")

                    val intent = Intent(this@SplashActivity, AnimationActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }

    override fun onInjected() {
        log.i("onInjected "+this)
    }

//    override fun onAnonymous() {
//        val intent = Intent(this, AnimationActivity::class.java)
//        startActivity(intent)
//    }

    override fun onLoginAnonymous() {
        val intent = Intent(this, AnimationActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginGoogle() {
        auth.signInWithGoogle(this)
    }

}

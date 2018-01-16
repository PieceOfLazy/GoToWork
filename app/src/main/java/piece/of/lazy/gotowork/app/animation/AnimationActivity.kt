package piece.of.lazy.gotowork.app.animation

import android.content.res.Configuration
import android.os.Bundle
import piece.of.lazy.gotowork.R
import piece.of.lazy.gotowork.base.BaseActivity
import piece.of.lazy.gotowork.firebase.FbAuth
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class AnimationActivity : BaseActivity<AnimationFragment, AnimationContract.Presenter>(), AnimationContract.ActivityListener {

    @Inject
    lateinit var auth: FbAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        log.i("onCreate")

        fragmentManager?.let {
            var fragment = it.findFragmentByTag(AnimationFragment::class.simpleName)
            if(fragment == null) {
                val transaction = it.beginTransaction()
                if(transaction != null) {
                    val tag = AnimationFragment::class.simpleName
                    fragment = this@AnimationActivity.fragment
                    transaction.replace(R.id.activity_base_fragment, fragment, tag).commit()
                }
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        AnimationFragment::class.simpleName?.let {
            fragmentRefresh(it)
        }
    }

    override fun onInjected() {
        log.i("onInjected "+this)
    }
}

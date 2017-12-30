package piece.of.lazy.gotowork.app

import android.os.Bundle
import piece.of.lazy.gotowork.R
import piece.of.lazy.gotowork.base.BaseActivity
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class SplashActivity : BaseActivity() {

    @Inject
    private lateinit var presenter: SplashPresenter
    @Inject
    private lateinit var fragment: SplashFragment

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
}

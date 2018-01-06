package piece.of.lazy.gotowork.base

import android.app.Fragment
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import piece.of.lazy.gotowork.R
import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView
import piece.of.lazy.ui.util.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
abstract class BaseActivity<V: BaseView<P>, P: BasePresenter<V>> : DaggerAppCompatActivity() {

    private val VIEW_TAG = "VIEW_TAG"
    private val PRESENTER_TAG = "PRESENTER_TAG"

    @Inject
    lateinit var presenter: P
    @Inject
    lateinit var fragment: V

    protected val log by lazy {
        Log(this::class.simpleName)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        log.i("onCreate")

        val view = findOrInjectView()
        val presenter = findOrInjectPresenter()

        presenter?.let {
            view?.setMVPPresenter(it)
        }
    }

    private fun findOrInjectView(): V? {
        fragmentManager?.let {
            var fragment = it.findFragmentByTag(VIEW_TAG)
            if(fragment == null) {
                val transaction = it.beginTransaction()
                if(transaction != null) {
                    if(this.fragment is Fragment) {
                        fragment = this.fragment as Fragment
                        transaction.add(R.id.activity_base_fragment, fragment, VIEW_TAG).commit()
                    }
                }
            }
            @Suppress("UNCHECKED_CAST")
            return fragment as? V
        }
        return null
    }

    private fun findOrInjectPresenter(): P? {
        fragmentManager?.let {
            @Suppress("UNCHECKED_CAST")
            val fragment = it.findFragmentByTag(PRESENTER_TAG) as? BasePresenterFragment<P>
            return if(fragment?.presenter != null) {
                fragment.presenter
            } else {
                val presenter = this.presenter
                val transaction = it.beginTransaction()
                transaction?.add(BasePresenterFragment.createBasePresenterFragment(presenter), PRESENTER_TAG)?.commit()
                presenter
            }
        }
        return null
    }
}
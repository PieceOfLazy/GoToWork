package piece.of.lazy.gotowork.base

import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerAppCompatActivity
import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView
import piece.of.lazy.gotowork.piece.LoadingPiece
import piece.of.lazy.ui.util.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
abstract class BaseActivity<V: BaseView<P>, P: BasePresenter<V>> : DaggerAppCompatActivity(), BaseActivityListener {

    @Inject
    lateinit var presenter: P
    @Inject
    lateinit var fragment: V

    private var loadingPiece: LoadingPiece? = null

    protected val log by lazy {
        Log(this::class.simpleName)
    }

    protected fun fragmentRefresh(tag: String) {
        fragmentManager?.let {
            val fragment = it.findFragmentByTag(tag)
            if (fragment != null) {
                val transaction = it.beginTransaction()
                transaction?.detach(fragment)?.attach(fragment)?.commit()
            }
        }
    }

    override fun onLoadingStart() {
        if(loadingPiece == null) {
            loadingPiece = LoadingPiece().apply {
                doCreateView(this@BaseActivity, findViewById<View>(android.R.id.content).rootView as? ViewGroup)
            }
        }

        loadingPiece?.start()
    }

    override fun onLoadingEnd() {
        loadingPiece?.end(100)
    }
}
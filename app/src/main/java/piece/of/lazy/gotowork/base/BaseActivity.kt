package piece.of.lazy.gotowork.base

import dagger.android.support.DaggerAppCompatActivity
import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView
import piece.of.lazy.ui.util.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
abstract class BaseActivity<V: BaseView<P>, P: BasePresenter<V>> : DaggerAppCompatActivity() {

    @Inject
    lateinit var presenter: P
    @Inject
    lateinit var fragment: V

    protected val log by lazy {
        Log(this::class.simpleName)
    }
}
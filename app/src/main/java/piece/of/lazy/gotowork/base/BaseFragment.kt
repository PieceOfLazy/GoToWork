package piece.of.lazy.gotowork.base

import android.content.Context
import dagger.android.DaggerFragment
import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView
import piece.of.lazy.gotowork.di.ActivityScoped
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
@ActivityScoped
abstract class BaseFragment<V: BaseView<P>, P: BasePresenter<V>> : DaggerFragment(), BaseView<P> {

    @Inject
    lateinit var presenter: P

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        presenter.onAttach(onCreatePresenterView())
    }

    override fun onDetach() {
        super.onDetach()

        presenter.onDetach()
    }

    abstract fun onCreatePresenterView(): V
}
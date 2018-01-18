package piece.of.lazy.gotowork.app.main

import piece.of.lazy.gotowork.base.BaseActivityListener
import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView

/**
 * @author piece.of.lazy
 */
interface MainContract {

    interface ActivityListener : BaseActivityListener {
        fun onInjected()
    }

    interface View : BaseView<Presenter> {
        fun onLaunched(model: Model, login: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun setAnimateAlpha(alpha: Float)
        fun setAnimateEnd()
    }

    data class Model(
            val animateAlpha: Float)
}
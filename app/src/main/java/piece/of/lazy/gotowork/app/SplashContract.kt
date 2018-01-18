package piece.of.lazy.gotowork.app

import piece.of.lazy.gotowork.base.BaseActivityListener
import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView

/**
 * @author piece.of.lazy
 */
interface SplashContract {

    interface ActivityListener : BaseActivityListener {
        fun onInjected()
        fun onLoginAnonymous()
        fun onLoginGoogle()
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
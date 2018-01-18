package piece.of.lazy.gotowork.app.splash

import piece.of.lazy.gotowork.base.BaseActivityListener
import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView

/**
 * @author piece.of.lazy
 */
interface SplashContract {

    interface ActivityListener : BaseActivityListener {
        fun onLoginAnonymous()
        fun onLoginGoogle()
    }

    interface View : BaseView<Presenter> {
        fun onLaunched(model: Model)
    }

    interface Presenter : BasePresenter<View> {
        fun setAnimateAlpha(alpha: Float)
        fun setAnimateEnd()

        fun setLoginState(state: Boolean)
    }

    data class Model(
            val animateAlpha: Float,
            val loginState: Boolean)
}
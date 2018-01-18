package piece.of.lazy.gotowork.app.splash

import piece.of.lazy.gotowork.base.mvp.BasePresenterDefault
import piece.of.lazy.gotowork.common.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class SplashPresenter @Inject constructor(private val log: Log, private var loginState: Boolean) : BasePresenterDefault<SplashContract.View>(), SplashContract.Presenter {
    private var animateAlpha = 0.0f
    private var loading = false

    override fun onLaunch() {
        view?.onLaunched(
                model = SplashContract.Model(animateAlpha, loginState))
    }

    override fun setAnimateAlpha(alpha: Float) {
        animateAlpha = alpha
    }

    override fun setAnimateEnd() {
        animateAlpha = 1.0f
        loading = true
        onLaunch()
    }

    override fun setLoginState(state: Boolean) {
        loginState = state
        onLaunch()
    }
}
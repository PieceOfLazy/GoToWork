package piece.of.lazy.gotowork.app

import piece.of.lazy.gotowork.base.mvp.BasePresenterDefault
import piece.of.lazy.gotowork.common.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class SplashPresenter @Inject constructor(val log: Log) : BasePresenterDefault<SplashContract.View>(), SplashContract.Presenter {

    private var animateAlpha = 0.0f
    private var loading = false

    override fun onLaunch() {
        view?.let {
            it.onLaunched(
                    model = SplashContract.Model(animateAlpha),
                    loading = loading)
        }
    }

    override fun setAnimateAlpha(alpha: Float) {
        animateAlpha = alpha
    }

    override fun setAnimateEnd() {
        animateAlpha = 1.0f
        loading = true
        onLaunch()
    }
}
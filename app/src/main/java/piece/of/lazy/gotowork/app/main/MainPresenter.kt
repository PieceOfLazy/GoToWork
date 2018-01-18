package piece.of.lazy.gotowork.app.main

import piece.of.lazy.gotowork.auth.LazyUser
import piece.of.lazy.gotowork.base.mvp.BasePresenterDefault
import piece.of.lazy.gotowork.common.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class MainPresenter @Inject constructor(private val log: Log, private val user: LazyUser?) : BasePresenterDefault<MainContract.View>(), MainContract.Presenter {

    private var animateAlpha = 0.0f
    private var loading = false

    override fun onLaunch() {
        view?.onLaunched(
                model = MainContract.Model(animateAlpha),
                login = user != null)
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
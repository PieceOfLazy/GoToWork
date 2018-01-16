package piece.of.lazy.gotowork.app.animation

import piece.of.lazy.gotowork.auth.LazyUser
import piece.of.lazy.gotowork.base.mvp.BasePresenterDefault
import piece.of.lazy.gotowork.common.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class AnimationPresenter @Inject constructor(private val log: Log, private val user: LazyUser?) : BasePresenterDefault<AnimationContract.View>(), AnimationContract.Presenter {

    private var animateAlpha = 0.0f
    private var loading = false

    override fun onLaunch() {
        view?.onLaunched(
                model = AnimationContract.Model(animateAlpha),
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
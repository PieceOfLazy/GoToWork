package piece.of.lazy.gotowork.app

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.splash_fragment.view.*
import kotlinx.android.synthetic.main.splash_piece_animation.view.*
import piece.of.lazy.gotowork.R
import piece.of.lazy.gotowork.base.BaseFragment
import piece.of.lazy.gotowork.di.ActivityScoped
import piece.of.lazy.ui.PieceOfView
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
@ActivityScoped
class SplashFragment @Inject constructor() : BaseFragment<SplashContract.View, SplashContract.Presenter, SplashContract.ActivityListener>(), SplashContract.View  {

    companion object {
        private val ANIMATE_DURATION: Long = 2000
    }

    private val animationSplash = AnimationSplash()

    override fun onBindPresenterView(): SplashContract.View {
        return this
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if(view == null) {
            inflater?.let {
                return init(it.inflate(R.layout.splash_fragment, container, false))
            }
        }
        return view
    }

    private fun init(container: View): View {
        with(container) {
            animationSplash.doBindView(splash_fragment_piece_animation)
        }
        return container
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener.onInjected()
    }

    override fun onResume() {
        super.onResume()

        presenter.onLaunch()
    }

    override fun onLaunched(model: SplashContract.Model, login: Boolean) {
        log.d("onLaunched")
        animationSplash.doBindItem(context, model.animateAlpha)
    }

    inner class AnimationSplash : PieceOfView<Float>() {

        override fun onLayout(): Int = R.layout.splash_piece_animation

        override fun onBindView(v: View) {
            with(v) {
                splash_piece_animation_anonymous?.setOnClickListener {
                    listener.onAnonymous()
                }
            }
        }

        override fun onBindItem(c: Context, item: Float?) {
            item?.let {
                if(item < 1.0f) {
                    doAnimation(item)
                } else {

                }
            }
        }

        private fun doAnimation(startAlpha: Float) {
            mView?.let {
                it.alpha = startAlpha
                it
                        .animate()
                        .alpha(1.0f)
                        .setDuration(((1 - startAlpha) * ANIMATE_DURATION).toLong())
                        .withLayer()
                        .setListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(p0: Animator?) {
                                presenter.setAnimateEnd()
                            }
                        })
                        .setUpdateListener {
                            mView?.let {
                                presenter.setAnimateAlpha(it.alpha)
                            }
                        }
                        .start()
            }
        }
    }
}
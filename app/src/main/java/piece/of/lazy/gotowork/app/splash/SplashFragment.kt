package piece.of.lazy.gotowork.app.splash

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
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
class SplashFragment @Inject constructor() : BaseFragment<SplashContract.View, SplashContract.Presenter, SplashContract.ActivityListener>(), SplashContract.View {
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

    override fun onResume() {
        super.onResume()

        presenter.onLaunch()
    }

    override fun onLaunched(model: SplashContract.Model) {
        animationSplash.doBindItem(context, model)
    }

    inner class AnimationSplash : PieceOfView<SplashContract.Model>() {
        private var loginContainer: View? = null

        override fun onLayout(): Int = R.layout.splash_piece_animation

        override fun onBindView(v: View) {
            with(v) {
                splash_piece_animation_anonymous?.setOnClickListener {
                    listener.onLoginAnonymous()
                }
                splash_piece_animation_login_google?.setOnClickListener {
                    listener.onLoginGoogle()
                }

                loginContainer = splash_piece_animation_login_container
            }
        }

        override fun onBindItem(c: Context, item: SplashContract.Model?) {
            item?.let {
                if(item.loginState) {
                    loginContainer?.visibility = View.GONE
                    if(item.animateAlpha < 1.0f) {
                        doAnimation(item.animateAlpha)
                    } else {
                        listener.onLoginAnonymous()
                    }
                } else {
                    loginContainer?.visibility = View.VISIBLE
                    if(item.animateAlpha < 1.0f) {
                        doAnimation(item.animateAlpha)
                    }
                }
            }
        }

        private fun doAnimation(startAlpha: Float) {
            mView?.let {
                it.alpha = startAlpha
                it
                        .animate()
                        .withLayer()
                        .alpha(1.0f)
                        .setInterpolator(DecelerateInterpolator())
                        .setDuration(((1 - startAlpha) * ANIMATE_DURATION).toLong())
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
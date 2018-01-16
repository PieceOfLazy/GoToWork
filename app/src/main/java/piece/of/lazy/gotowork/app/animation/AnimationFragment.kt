package piece.of.lazy.gotowork.app.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import kotlinx.android.synthetic.main.splash_fragment.view.*
import kotlinx.android.synthetic.main.splash_piece_animation.view.*
import piece.of.lazy.gotowork.R
import piece.of.lazy.gotowork.app.SplashFragment
import piece.of.lazy.gotowork.base.BaseFragment
import piece.of.lazy.gotowork.di.ActivityScoped
import piece.of.lazy.ui.PieceOfView
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
@ActivityScoped
class AnimationFragment @Inject constructor() : BaseFragment<AnimationContract.View, AnimationContract.Presenter, AnimationContract.ActivityListener>(), AnimationContract.View  {

    companion object {
        private val ANIMATE_DURATION: Long = 2000
    }

    override fun onBindPresenterView(): AnimationContract.View {
        return this
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if(view == null) {
            inflater?.let {
                return init(it.inflate(R.layout.animation_fragment, container, false))
            }
        }
        return view
    }

    private fun init(container: View): View {
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


    private var imageView: ImageView? = null

    override fun onLaunched(model: AnimationContract.Model, login: Boolean) {
        log.d("onLaunched")

        val container = view as? ViewGroup
        val li = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as? LayoutInflater

        val cardView = li?.inflate(R.layout.animation_piece, container, false)?.apply {
            scaleX = 3.0f
            scaleY = 3.0f
        }
        container?.addView(cardView)

        cardView?.let {
            it
                    .animate()
                    .scaleX(1.0f)
                    .scaleY(1.0f)
                    .setDuration(1000)
                    .setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.bounce_interpolator))
//                    .alpha(1.0f)
//                    .setDuration(((1 - startAlpha) * SplashFragment.ANIMATE_DURATION).toLong())
//                    .withLayer()
//                    .setListener(object : AnimatorListenerAdapter() {
//                        override fun onAnimationEnd(p0: Animator?) {
//                            presenter.setAnimateEnd()
//                        }
//                    })
//                    .setUpdateListener {
//                        mView?.let {
//                            presenter.setAnimateAlpha(it.alpha)
//                        }
//                    }
                    .start()
        }
//        imageView = ImageView(context).apply {
//            layoutParams = FrameLayout.LayoutParams(900, 300, Gravity.CENTER)
//            setImageResource(R.mipmap.img_splash)
//            scaleType = ImageView.ScaleType.CENTER_CROP
//            scaleX = 3.0f
//            scaleY = 3.0f
//        }
//        (view as? FrameLayout)?.addView(imageView)
//
//        imageView?.let {
//            it
//                    .animate()
//                    .scaleX(1.0f)
//                    .scaleY(1.0f)
//                    .setDuration(1000)
//                    .setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.anticipate_overshoot_interpolator))
////                    .alpha(1.0f)
////                    .setDuration(((1 - startAlpha) * SplashFragment.ANIMATE_DURATION).toLong())
////                    .withLayer()
////                    .setListener(object : AnimatorListenerAdapter() {
////                        override fun onAnimationEnd(p0: Animator?) {
////                            presenter.setAnimateEnd()
////                        }
////                    })
////                    .setUpdateListener {
////                        mView?.let {
////                            presenter.setAnimateAlpha(it.alpha)
////                        }
////                    }
//                    .start()
//        }
    }


}
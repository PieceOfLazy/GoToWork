package piece.of.lazy.gotowork.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import piece.of.lazy.gotowork.R
import piece.of.lazy.gotowork.base.BaseFragment
import piece.of.lazy.gotowork.di.ActivityScoped
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
@ActivityScoped
class SplashFragment @Inject constructor() : BaseFragment<SplashContract.View, SplashContract.Presenter, SplashContract.ViewListener>(), SplashContract.View  {

    init {
        log.i("SplashFragment init")
    }
    override fun onBindPresenterView(): SplashContract.View {
        return this
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if(view == null) {
            inflater?.let {
                return it.inflate(R.layout.splash_fragment, container, false)
            }
        }
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener.onInjected()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
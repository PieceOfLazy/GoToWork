package piece.of.lazy.gotowork.app

import piece.of.lazy.gotowork.common.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
class SplashPresenter @Inject constructor(val log: Log) : SplashContract.Presenter {

    private var view : SplashContract.View? = null

    override fun onAttach(view: SplashContract.View) {
        this.view = view

        log.d("onAttach")
    }

    override fun onDetach() {
        this.view = null

        log.d("onDetach")
    }

    override fun onLaunch() {

    }

}
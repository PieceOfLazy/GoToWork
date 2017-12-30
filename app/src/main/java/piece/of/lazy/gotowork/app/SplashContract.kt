package piece.of.lazy.gotowork.app

import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView

/**
 * @author piece.of.lazy
 */
interface SplashContract {
    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter<View> {

    }
}
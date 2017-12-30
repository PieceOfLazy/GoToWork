package piece.of.lazy.gotowork.app

import piece.of.lazy.gotowork.base.BaseFragment

/**
 * @author piece.of.lazy
 */
class SplashFragment : BaseFragment<SplashContract.View, SplashContract.Presenter>(), SplashContract.View  {


    override fun onCreatePresenterView(): SplashContract.View {
        return this
    }


}
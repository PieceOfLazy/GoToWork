package piece.of.lazy.gotowork.base.mvp

/**
 * @author piece.of.lazy
 */
interface BasePresenter<in V> {

    fun onAttach(view: V)

    fun onDetach()

    fun onLaunch()
}
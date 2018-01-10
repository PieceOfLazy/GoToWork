package piece.of.lazy.gotowork.base.mvp

/**
 * @author piece.of.lazy
 */
abstract class BasePresenterDefault<V> : BasePresenter<V> {

    protected var view : V? = null

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }
}
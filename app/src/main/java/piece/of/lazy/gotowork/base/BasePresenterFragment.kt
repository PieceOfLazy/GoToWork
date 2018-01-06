package piece.of.lazy.gotowork.base

import android.app.Fragment
import android.os.Bundle

/**
 * @author piece.of.lazy
 */
class BasePresenterFragment<P> : Fragment() {

    var presenter: P? = null
        private set

    companion object {
        fun <P> createBasePresenterFragment(presenter: P): BasePresenterFragment<P> {
            val fragment = BasePresenterFragment<P>()
            fragment.presenter = presenter
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
}
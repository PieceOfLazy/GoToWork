package piece.of.lazy.gotowork.base

import android.content.Context
import dagger.android.DaggerFragment
import piece.of.lazy.gotowork.base.mvp.BasePresenter
import piece.of.lazy.gotowork.base.mvp.BaseView
import piece.of.lazy.gotowork.di.ActivityScoped
import piece.of.lazy.ui.util.Log
import javax.inject.Inject

/**
 * @author piece.of.lazy
 */
@ActivityScoped
abstract class BaseFragment<V: BaseView<P>, P: BasePresenter<V>, L: Any> : DaggerFragment(), BaseView<P> {

    @Inject
    protected lateinit var presenter: P

    @Inject
    protected lateinit var listener: L

    protected val log by lazy {
        Log(this::class.simpleName)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        presenter.onAttach(onBindPresenterView())
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }
//
//    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//
//    override fun onResume() {
//        super.onResume()
//    }
//
//    override fun onPause() {
//        super.onPause()
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }

    override fun onDetach() {
        super.onDetach()

        presenter.onDetach()
    }

    abstract fun onBindPresenterView(): V
}
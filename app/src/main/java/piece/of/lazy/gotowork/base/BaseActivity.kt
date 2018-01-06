package piece.of.lazy.gotowork.base

import dagger.android.support.DaggerAppCompatActivity
import piece.of.lazy.ui.util.Log

/**
 * @author piece.of.lazy
 */
abstract class BaseActivity : DaggerAppCompatActivity() {
    protected val log by lazy {
        Log(this::class.simpleName)
    }
}
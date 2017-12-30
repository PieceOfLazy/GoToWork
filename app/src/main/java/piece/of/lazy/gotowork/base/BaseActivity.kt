package piece.of.lazy.gotowork.base

import android.support.v7.app.AppCompatActivity
import piece.of.lazy.ui.util.Log

/**
 * @author piece.of.lazy
 */
abstract class BaseActivity : AppCompatActivity() {
    protected val log by lazy {
        val simpleName = this::class.simpleName
        if(simpleName != null) {
            Log(simpleName)
        } else {
            Log("")
        }
    }
}
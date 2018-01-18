package piece.of.lazy.gotowork.base

import android.support.annotation.StringRes
import android.widget.Toast

/**
 * @author piece.of.lazy
 */
interface BaseActivityListener {
    fun onLoadingStart()

    fun onLoadingEnd()

    fun onShowToast(msg: String, duration: Int = Toast.LENGTH_SHORT)

    fun onShowToast(@StringRes msg: Int, duration: Int = Toast.LENGTH_SHORT)
}
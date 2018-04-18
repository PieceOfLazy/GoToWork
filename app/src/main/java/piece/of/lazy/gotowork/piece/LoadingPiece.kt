package piece.of.lazy.gotowork.piece

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import piece.of.lazy.gotowork.R
import piece.of.lazy.ui.PieceOfView

/**
 * @author piece.of.lazy
 */
class LoadingPiece : PieceOfView<Unit>() {

    private var loading = false

    override fun onLayout(): Int = R.layout.piece_of_loading

    override fun onBindView(v: View) {
    }

    override fun onBindItem(c: Context, item: Unit?) {
    }

    fun start() {
        loading = true
        mView?.visibility = View.VISIBLE
    }

    fun end(delay: Long = 0) {
        loading = false

        if(delay > 0) {
            Handler(Looper.getMainLooper()).postDelayed({
                if(!loading) {
                    mView?.visibility = View.GONE
                }
            }, delay)
        } else {
            mView?.visibility = View.GONE
        }
    }
}
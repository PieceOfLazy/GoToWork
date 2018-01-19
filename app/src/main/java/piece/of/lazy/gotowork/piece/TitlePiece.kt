package piece.of.lazy.gotowork.piece

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import piece.of.lazy.gotowork.R
import piece.of.lazy.ui.PieceOfHolder

/**
 * @author piece.of.lazy
 */
class TitlePiece : PieceOfHolder<TitlePiece.Holder, TitlePiece.Item>(Holder::class, Item::class) {
    override fun onLayout(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolderPiece(view: View): Holder = Holder(view)

    override fun onBindViewHolderPiece(context: Context, holder: Holder, item: Item, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    inner class Item {

    }
}

data class TitlePieceItem(
        var title: String

)
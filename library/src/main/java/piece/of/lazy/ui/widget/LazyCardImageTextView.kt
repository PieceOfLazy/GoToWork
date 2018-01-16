package piece.of.lazy.ui.widget

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.lazy_image_text_view.view.*
import piece.of.lazy.ui.R


/**
 * @author piece.of.lazy
 */
class LazyCardImageTextView : CardView {

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0): super(context, attrs, defStyleAttr) {

        val li = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as? LayoutInflater
        val view = li?.inflate(R.layout.lazy_image_text_view, this, false)

        if(view is LinearLayout) {
            containerView = view
            addView(containerView)

            with(containerView) {
                imageView = lazy_image_text_view_image
                textView = lazy_image_text_view_text
            }
            initAttrs(attrs, defStyleAttr)
        }
    }

    private var containerView: LinearLayout? = null
    private var imageView: ImageView? = null
    private var textView: TextView? = null

    private fun initAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.LazyCardImageTextView)
        typedArray?.let {
            val orientation = it.getInt(R.styleable.LazyCardImageTextView_orientation, 0)
            if(orientation == 1) {
                containerView?.orientation = LinearLayout.VERTICAL
            } else {
                containerView?.orientation = LinearLayout.HORIZONTAL
            }

            val imageWidth = it.getDimensionPixelSize(R.styleable.LazyCardImageTextView_imageWidth, ViewGroup.LayoutParams.WRAP_CONTENT)
            val imageHeight = it.getDimensionPixelSize(R.styleable.LazyCardImageTextView_imageHeight, ViewGroup.LayoutParams.WRAP_CONTENT)
            val imageSpace = it.getDimensionPixelSize(R.styleable.LazyCardImageTextView_imageSpace, 0)
            val imageSrc = it.getDrawable(R.styleable.LazyCardImageTextView_imageSrc)

            imageView?.let {
                if(imageSrc != null) {
                    it.visibility = View.VISIBLE
                    (it.layoutParams as? LinearLayout.LayoutParams)?.apply {
                        width = imageWidth
                        height = imageHeight
                        marginEnd = imageSpace
                    }
                    it.setImageDrawable(imageSrc)
                } else {
                    it.visibility = View.GONE
                }
            }

            val style = it.getInt(R.styleable.LazyCardImageTextView_layoutStyle, 0)
            val textSize = it.getDimensionPixelSize(R.styleable.LazyCardImageTextView_textSize, 0)
            val textColor = it.getColorStateList(R.styleable.LazyCardImageTextView_textColor)
            val textStyle = it.getInt(R.styleable.LazyCardImageTextView_textStyle, 0)
            val text = it.getText(R.styleable.LazyCardImageTextView_text)

            textView?.let {
                if(style == 1) {
                    (it.layoutParams as? LinearLayout.LayoutParams)?.apply {
                        width = 0
                        height = ViewGroup.LayoutParams.WRAP_CONTENT
                        weight = 1f
                    }
                } else {
                    (it.layoutParams as? LinearLayout.LayoutParams)?.apply {
                        width = ViewGroup.LayoutParams.WRAP_CONTENT
                        height = ViewGroup.LayoutParams.WRAP_CONTENT
                    }
                }

                it.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize.toFloat())
                if(textColor != null) {
                    it.setTextColor(textColor)
                }
                if(textStyle == 1) {
                    it.typeface = Typeface.DEFAULT_BOLD
                } else {
                    it.typeface = Typeface.DEFAULT
                }
                it.text = text
            }
        }
        typedArray?.recycle()
    }
}
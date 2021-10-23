package me.adswt518.dog_adoption

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import android.widget.FrameLayout

class SearchBox @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var listener: ChangedListener? = null

    init {
        inflate(context, R.layout.search_box, this)

        findViewById<EditText>(R.id.input).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                listener?.onTextChanged(s.toString())
            }

        })
    }

    fun setTextChangedListener(listener: ChangedListener) {
        this.listener = listener
    }

    interface ChangedListener {
        fun onTextChanged(text: String)
    }

}
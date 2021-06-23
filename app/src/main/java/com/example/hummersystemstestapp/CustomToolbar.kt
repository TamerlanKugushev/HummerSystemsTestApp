package com.example.hummersystemstestapp

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class CustomToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0
) : LinearLayout(context, attrs, defStyleAttrs) {

    init {
        inflate(context, R.layout.toolbar_menu, this)
    }
}
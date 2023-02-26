package com.example.homework19.ui.utils

import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object RecyclerViewDataBinding {

    @JvmStatic
    @BindingAdapter("goneUnless")
    fun RecyclerView.isVisible(
        visibility: Boolean
    ) {
        isVisible = visibility.not()
    }
}
package com.example.homework19.ui.utils

import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

object ProgressBarDataBinding {

    @JvmStatic
    @BindingAdapter("goneUnless")
    fun ProgressBar.isVisible(
        visibility: Boolean
    ) {
        isVisible = visibility
    }
}
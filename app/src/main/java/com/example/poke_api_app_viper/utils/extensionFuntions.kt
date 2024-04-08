package com.example.poke_api_app_viper.utils

import androidx.fragment.app.Fragment
import com.example.poke_api_app_viper.view.common.CustomDialog

fun Fragment.showCustomDialog(message: String, ) {
    CustomDialog(
        context = requireContext(),
        message = message,
    )
}
fun Fragment.dismissCustomDialog() {
    CustomDialog(context = requireContext(),message = "").dismiss()
}
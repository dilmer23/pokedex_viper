package com.example.poke_api_app_viper.view.common

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.databinding.DialogLoadingBinding

class CustomDialog(
    context: Context,
    private val message: String?
) {
    private val binding: DialogLoadingBinding = DialogLoadingBinding.inflate(LayoutInflater.from(context))
    private var alertDialog: AlertDialog? = null

    init {
        alertDialog = AlertDialog.Builder(context)
            .setView(binding.root)
            .setCancelable(false)
            .create()

        binding.loadingMessageTextView.text = message

        // Llama a show() después de configurar el mensaje
        alertDialog?.show()

        // Configura el fondo transparente después de mostrar el diálogo
        alertDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun dismiss() {
        alertDialog?.dismiss()
    }
}


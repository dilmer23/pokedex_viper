package com.example.poke_api_app_viper.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import com.example.poke_api_app_viper.R

class PokemonCustomLoadingDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        setCancelable(false)
    }

    fun setMessage(message: String) {
        val loadingMessageTextView = findViewById<TextView>(R.id.loadingMessageTextView)
        loadingMessageTextView.text = message
    }
}
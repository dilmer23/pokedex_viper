package com.example.poke_api_app_viper.contract

import android.content.Context

class PokemonCustomDialog {
    interface View {
        fun showCustomDialog(context: Context)
    }
    interface Presenter {
        fun customDialogShowInput()
    }
    interface Router {
        fun customDialogShowOnput(url: String?)
    }
}
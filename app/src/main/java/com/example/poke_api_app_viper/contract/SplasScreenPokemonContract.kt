package com.example.poke_api_app_viper.contract

import android.content.Context

interface SplasScreenPokemonContract {

    interface View {
        val context: Context
        fun showSplashScreen()
        fun navigateToMainScreen()
    }

    interface Presenter {
        fun onViewCreated()
    }

    interface Interactor {
        fun delayForSplashScreen()
    }

    interface Router {
        fun navigateToMainScreen()
    }
}
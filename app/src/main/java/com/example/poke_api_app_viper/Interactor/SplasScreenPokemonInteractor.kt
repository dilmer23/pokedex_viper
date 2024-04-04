package com.example.poke_api_app_viper.Interactor

import android.os.Handler
import android.os.Looper
import com.example.poke_api_app_viper.contract.SplasScreenPokemonContract
import com.example.poke_api_app_viper.presenter.SplasScreenPresenter

class SplasScreenPokemonInteractor(private val presenter: SplasScreenPokemonContract.Presenter) : SplasScreenPokemonContract.Interactor {
    override fun delayForSplashScreen() {
        val delayMillis = 2000L
        Handler(Looper.getMainLooper()).postDelayed({
            presenter.onViewCreated()
        }, delayMillis)
    }
}
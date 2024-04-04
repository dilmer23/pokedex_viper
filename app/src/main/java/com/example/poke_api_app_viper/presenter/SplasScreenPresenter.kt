package com.example.poke_api_app_viper.presenter

import com.example.poke_api_app_viper.Interactor.SplasScreenPokemonInteractor
import com.example.poke_api_app_viper.contract.SplasScreenPokemonContract

class SplasScreenPresenter(private val view: SplasScreenPokemonContract.View,
                           private val interactor : SplasScreenPokemonContract.Interactor,
                           private val router: SplasScreenPokemonContract.Router): SplasScreenPokemonContract.Presenter {

    override fun onViewCreated() {
        view.showSplashScreen()
        interactor.delayForSplashScreen()
    }

    fun onSplashScreenDelayFinished() {
        router.navigateToMainScreen()
    }
}
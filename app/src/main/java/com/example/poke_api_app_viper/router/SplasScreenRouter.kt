package com.example.poke_api_app_viper.router

import com.example.poke_api_app_viper.view.MainActivity
import android.content.Context
import android.content.Intent
import com.example.poke_api_app_viper.contract.SplasScreenPokemonContract

class SplasScreenRouter(private val context: Context):SplasScreenPokemonContract.Router {
    override fun navigateToMainScreen() {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}
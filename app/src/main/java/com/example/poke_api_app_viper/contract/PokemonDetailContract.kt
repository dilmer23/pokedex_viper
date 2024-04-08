package com.example.poke_api_app_viper.contract

import PokemonDetailEntity

interface PokemonDetailContract {
    interface View {
        fun showPokemonDetail(data:  PokemonDetailEntity)
        fun showErrorDetail(message: String)
        fun dismisAlerDialog()
        fun showAlerDialog(message: String)
    }
    interface Presenter {
        fun getPokemonDetail(id:String)
    }
}
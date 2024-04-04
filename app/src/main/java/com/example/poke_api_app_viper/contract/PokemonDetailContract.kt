package com.example.poke_api_app_viper.contract

import PokemonDetailEntity

interface PokemonDetailContract {
    interface View {
        //cargar data
        fun showPokemonDetail(data:  PokemonDetailEntity)
        //mostrar errores
        fun showErrorDetail(message: String)
    }
    interface Presenter {
        // intermediador de interator y vista
        fun getPokemonDetail(id:String)
    }
}
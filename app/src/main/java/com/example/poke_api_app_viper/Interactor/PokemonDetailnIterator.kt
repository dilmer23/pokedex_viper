package com.example.poke_api_app_viper.Interactor

import PokeApiService
import PokemonDetailEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonDetailnIterator {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pokeApiService = retrofit.create(PokeApiService::class.java)
    suspend fun getPokemonDetail(id:String): PokemonDetailEntity {
        return pokeApiService.getPokemonDetail(id)
    }
}
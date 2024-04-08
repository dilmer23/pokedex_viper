package com.example.poke_api_app_viper.presenter

import com.example.poke_api_app_viper.Interactor.PokemonDetailnIterator
import com.example.poke_api_app_viper.contract.PokemonDetailContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonDetailPresenter(private val view: PokemonDetailContract.View):PokemonDetailContract.Presenter {
    private val iterator = PokemonDetailnIterator()

    override fun getPokemonDetail(url:String) {
        GlobalScope.launch(Dispatchers.Main) {
            view.showAlerDialog("Cargando...")
            try {
                val dataDeferred = GlobalScope.async(Dispatchers.IO) {
                    iterator.getPokemonDetail(url)
                }
                val data = dataDeferred.await()
                view.dismisAlerDialog()
                view.showPokemonDetail(data)
            } catch (e: Exception) {
                view.showErrorDetail(e.message ?: "Error desconocido")
            }
        }
    }

}
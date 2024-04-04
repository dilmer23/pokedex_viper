package com.example.poke_api_app_viper.router

import PokemonContract
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.view.PokemonDetailFragment


class PokemonRouter(private val view: PokemonContract.View,private val context: Context?) : PokemonContract.Router {
    override fun navigateToFragmentScreen(url: String?) {
        if (url != null) {
            val fragment = PokemonDetailFragment.newInstance(url)
            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
            Log.d("valor", url)
        }
    }
}
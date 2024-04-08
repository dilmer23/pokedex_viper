package com.example.poke_api_app_viper.view

import PokemonFragment
import PokemonPresenter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poke_api_app_viper.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
//    lateinit var homePresenter: PokemonPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PokemonFragment())
            .commit()
    }
}

package com.example.poke_api_app_viper.view

import PokemonFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poke_api_app_viper.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PokemonFragment())
            .commit()
    }
}

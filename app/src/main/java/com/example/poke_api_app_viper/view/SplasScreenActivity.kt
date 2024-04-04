package com.example.poke_api_app_viper.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poke_api_app_viper.Interactor.SplasScreenPokemonInteractor
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.contract.SplasScreenPokemonContract
import com.example.poke_api_app_viper.presenter.SplasScreenPresenter
import com.example.poke_api_app_viper.router.SplasScreenRouter

class SplasScreenActivity : AppCompatActivity(), SplasScreenPokemonContract.View  {
    private lateinit var presenter: SplasScreenPokemonContract.Presenter
    private lateinit var router: SplasScreenPokemonContract.Router
    override val context: Context
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splas_screen)

        presenter = SplasScreenPresenter(
            this,
            SplasScreenPokemonInteractor(presenter),
            SplasScreenRouter(this)
        )
    }

    override fun onResume() {
        super.onResume()
        // Llamar al método onViewCreated() del presentador cuando la vista está lista para ser mostrada
        presenter.onViewCreated()
    }

    override fun navigateToMainScreen() {
        router.navigateToMainScreen()
    }

    override fun showSplashScreen() {
        presenter.onViewCreated()
    }
}

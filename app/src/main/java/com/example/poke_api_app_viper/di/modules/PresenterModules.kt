package com.example.poke_api_app_viper.di.modules

import PokemonContract
import PokemonPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModules {
    @Provides
    fun provideHomePresenter(iterator:PokemonContract.Presenter):
            PokemonContract.Presenter = iterator
}
//package com.example.poke_api_app_viper.di.modules
//
//import PokemonContract
//import PokemonFragment
//import PokemonInteractor
//import PokemonPresenter
//import dagger.Module
//import dagger.Provides
//
//@Module
//class PresenterModules {
//    @Provides
//    fun providePokemonFragment(
//        interactor :PokemonInteractor,
//        view: PokemonContract.View
//    ): PokemonContract.Presenter = PokemonPresenter(view, interactor)
//}
interface PokemonContract {
    //contrato de la vista
    interface View {
        //cargar data
        fun showPokemonList(data:  PokemonEntity)
        //mostrar errores
        fun showError(message: String)
    }
    interface Presenter {
        // intermediador de interator y vista
        fun getPokemonList()
    }
    interface Router {
        fun navigateToFragmentScreen(url: String?)
    }
}

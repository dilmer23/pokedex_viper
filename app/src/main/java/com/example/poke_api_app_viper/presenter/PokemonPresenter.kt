import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonPresenter(private val view: PokemonContract.View) : PokemonContract.Presenter {

    private val interactor = PokemonInteractor()

    override fun getPokemonList() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                view.showAlerDialog("Estamos obteniendo Pokemos")
                val data = withContext(Dispatchers.IO) {
                    interactor.getPokemonList()
                }
                view.dismisAlerDialog()
                view.showPokemonList(data)
            } catch (e: Exception) {
                view.showError(e.message ?: "Error desconocido")
            }
        }
    }

}

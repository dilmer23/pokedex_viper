import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke_api_app_viper.databinding.FragmentPokemonBinding
import com.example.poke_api_app_viper.router.PokemonRouter
import com.example.poke_api_app_viper.view.common.CustomDialog

class PokemonFragment : Fragment(), PokemonContract.View {

    private lateinit var presenter: PokemonContract.Presenter
    private lateinit var route: PokemonContract.Router
    private lateinit var adapter: PokemonAdapter
    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!
    private var customDialog: CustomDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PokemonPresenter(this)
        presenter.getPokemonList()
        route = PokemonRouter(this,context)
        adapter = PokemonAdapter(route)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showPokemonList(pokemonList:  PokemonEntity) {
         val data = pokemonList.results
        if (data != null) {
            adapter.setData(data)
        }
    }


    override fun showError(message: String) {
        // Implementa la lógica para mostrar un mensaje de error en caso de fallo en la obtención de datos
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    override fun showAlerDialog(message: String) {
        customDialog = CustomDialog(requireContext(), message)
    }

    override fun dismisAlerDialog() {
        customDialog?.dismiss()
    }
}

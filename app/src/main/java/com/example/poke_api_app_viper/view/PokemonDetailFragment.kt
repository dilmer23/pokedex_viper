package com.example.poke_api_app_viper.view

import PokemonDetailEntity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.contract.PokemonDetailContract
import com.example.poke_api_app_viper.databinding.FragmentPokemonBinding
import com.example.poke_api_app_viper.databinding.FragmentPokemonDetailBinding
import com.example.poke_api_app_viper.presenter.PokemonDetailPresenter
import com.example.poke_api_app_viper.utils.GlobalVars


class PokemonDetailFragment : Fragment() , PokemonDetailContract.View {
    private lateinit var presenter: PokemonDetailContract.Presenter
    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!


    companion object {
        private const val ARG_URL = "url"

        fun newInstance(url: String): PokemonDetailFragment {
            val fragment = PokemonDetailFragment()
            val args = Bundle()
            args.putString(ARG_URL, url)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString(ARG_URL)
        presenter = PokemonDetailPresenter(this)
        if (url != null) {
            presenter.getPokemonDetail(url)
        }


    }

    override fun showPokemonDetail(data: PokemonDetailEntity) {
            binding.namePokemon.text = data.name
            binding.locationAreaEncountersPokemon.text = data.height.toString()
            Glide.with(this)
                .load(GlobalVars.imgPomemonDetail+data.id+".png")
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .into(binding.imageViewDetail)
    }

    override fun showErrorDetail(message: String) {
        // Implementa la lógica para mostrar un mensaje de error en caso de fallo en la obtención de datos
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
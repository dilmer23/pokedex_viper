package com.example.poke_api_app_viper.view.common

import Ability
import Type
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.databinding.FragmentPokemonAbilitiesBinding
import com.example.poke_api_app_viper.databinding.FragmentPokemonBinding
import com.example.poke_api_app_viper.view.PokemonDetailFragment
import com.example.poke_api_app_viper.view.adapter.PokemonAbilitiesAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class PokemonAbilitiesFragment : Fragment() {

    private var _binding: FragmentPokemonAbilitiesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PokemonAbilitiesAdapter

    companion object {
        private const val ARG_URL = "url"
        private const val COLOR = "color"

        fun newInstance(url: String, color: Int): PokemonAbilitiesFragment {
            val fragment = PokemonAbilitiesFragment()
            val args = Bundle()
            args.putString(ARG_URL, url)
            args.putInt(COLOR, color)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonAbilitiesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString(ARG_URL)
        val color = arguments?.getInt(COLOR)
        adapter = PokemonAbilitiesAdapter()
        binding.rcAbility.layoutManager = LinearLayoutManager(requireContext())
        binding.rcAbility.adapter = adapter


        val gson = Gson()
        // Definir el tipo correcto para la conversión
        val abilityListType = object : TypeToken<List<Ability>>() {}.type
        val abilityList: List<Ability> = gson.fromJson(data,abilityListType)

        adapter.setData(abilityList,color!!)

    }
}
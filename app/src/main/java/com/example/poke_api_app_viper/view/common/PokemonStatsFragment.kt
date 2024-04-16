package com.example.poke_api_app_viper.view.common

import Stat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.databinding.FragmentPokemonAbilitiesBinding
import com.example.poke_api_app_viper.databinding.FragmentPokemonStatsBinding
import com.example.poke_api_app_viper.view.adapter.PokemonAbilitiesAdapter
import com.example.poke_api_app_viper.view.adapter.PokemonStatAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class PokemonStatsFragment : Fragment() {

    private var _binding : FragmentPokemonStatsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter:PokemonStatAdapter

    companion object {
        private const val ARG_URL = "url"
        private const val COLOR = "color"

        fun newInstance(url: String, color: Int): PokemonStatsFragment {
            val fragment = PokemonStatsFragment()
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
        _binding = FragmentPokemonStatsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString(PokemonStatsFragment.ARG_URL)
        val color = arguments?.getInt(PokemonStatsFragment.COLOR)
        adapter = PokemonStatAdapter()
        binding.rcStats.layoutManager = LinearLayoutManager(requireContext())
        binding.rcStats.adapter = adapter
        val gson = Gson()
        // Definir el tipo correcto para la conversión
        val statListType = object : TypeToken<List<Stat>>() {}.type
        val statLis: List<Stat> = gson.fromJson(data, statListType)

        adapter.setData(statLis, color!!)
      }

    }
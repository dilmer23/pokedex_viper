package com.example.poke_api_app_viper.view.common

import Move
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke_api_app_viper.databinding.FragmentPokemonMovesBinding
import com.example.poke_api_app_viper.view.adapter.PokemonMovesAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class PokemonMovesFragment : Fragment() {

    private var _binding : FragmentPokemonMovesBinding? =  null
    private val binding get() = _binding!!
    private  lateinit var adapter: PokemonMovesAdapter

    companion object {
        private const val ARG_URL = "url"
        private const val COLOR = "color"

        fun newInstance(url: String, color: Int): PokemonMovesFragment {
            val fragment = PokemonMovesFragment()
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
        _binding = FragmentPokemonMovesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString(PokemonMovesFragment.ARG_URL)
        val color = arguments?.getInt(PokemonMovesFragment.COLOR)
        adapter = PokemonMovesAdapter()
        binding.rcMoves.layoutManager = LinearLayoutManager(requireContext())
        binding.rcMoves.adapter = adapter
        val gson = Gson()
        // Definir el tipo correcto para la conversión
        val moveListType = object : TypeToken<List<Move>>() {}.type
        val moveLis: List<Move> = gson.fromJson(data, moveListType)

        adapter.setData(moveLis, color!!)
    }
}
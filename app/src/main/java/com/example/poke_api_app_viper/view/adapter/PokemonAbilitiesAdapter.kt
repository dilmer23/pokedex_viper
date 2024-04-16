package com.example.poke_api_app_viper.view.adapter

import Ability
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poke_api_app_viper.R

class PokemonAbilitiesAdapter : RecyclerView.Adapter<PokemonAbilitiesAdapter.PokemonAbilitiesViewHolder>() {
    private var pokemonAbilitiesList = listOf<Ability>()
    private var colorData = 0

    fun setData(data: List<Ability>, color : Int) {
        pokemonAbilitiesList = data
        colorData = color
        notifyItemChanged(pokemonAbilitiesList.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAbilitiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ability, parent, false)
        return PokemonAbilitiesViewHolder(view)
    }
    override fun onBindViewHolder(holder: PokemonAbilitiesViewHolder, position: Int) {
        val pokemonAbilities = pokemonAbilitiesList[position]
        holder.bind(pokemonAbilities,position,colorData)
    }
    override fun getItemCount(): Int {
        return pokemonAbilitiesList.size
    }

    class PokemonAbilitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewAbilities: TextView = itemView.findViewById(R.id.textViewAbilities)
        private val textViewAbilitiesId: TextView = itemView.findViewById(R.id.textViewIdAbilities)
        private  val backgroud : RelativeLayout = itemView.findViewById(R.id.relativeLayoutBackground2)

        fun bind(pokemonAbilities: Ability, position: Int, colorData: Int) {
            val idContador = position + 1
            textViewAbilities.text = pokemonAbilities.ability?.name.toString()
            textViewAbilitiesId.text = idContador.toString()
            backgroud.setBackgroundColor(colorData)

        }
    }
}
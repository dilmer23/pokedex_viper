package com.example.poke_api_app_viper.view.adapter

import Stat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poke_api_app_viper.R

class PokemonStatAdapter: RecyclerView.Adapter<PokemonStatAdapter.PokemonStatViewHolder>() {
    private var pokemonStatList = listOf<Stat>()
    private var colorData = 0
    fun setData(data: List<Stat>, color : Int) {
        pokemonStatList = data
        colorData = color
        notifyItemChanged(pokemonStatList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonStatAdapter.PokemonStatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stats, parent, false)
        return PokemonStatViewHolder(view)
    }
    override fun onBindViewHolder(holder: PokemonStatViewHolder, position: Int) {
        val pokemonStat = pokemonStatList[position]
        holder.bind(pokemonStat,position,colorData)
    }
    override fun getItemCount(): Int {
        return pokemonStatList.size
    }
    class PokemonStatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewStat: TextView = itemView.findViewById(R.id.textViewStat)
        private val textViewStatId: TextView = itemView.findViewById(R.id.textViewIdStat)
        private val linearIndicador : ProgressBar = itemView.findViewById(R.id.progressBarHP)
        private  val backgroud : RelativeLayout = itemView.findViewById(R.id.relativeLayoutBackground3)

        fun bind(pokemonStas: Stat, position: Int, colorData: Int) {
            val idContador = position + 1
            textViewStat.text = pokemonStas.stat?.name.toString()
            linearIndicador.progress = 50
            textViewStatId.text = idContador.toString()
            backgroud.setBackgroundColor(colorData)

        }
    }
}
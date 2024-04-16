package com.example.poke_api_app_viper.view.adapter

import Move
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poke_api_app_viper.R

class PokemonMovesAdapter : RecyclerView.Adapter<PokemonMovesAdapter.PokemonMovesViewHolder>() {
    private var pokemonMovesList = listOf<Move>()
    private var colorData = 0
    fun setData(data: List<Move>, color : Int) {
        pokemonMovesList = data
        colorData = color
        notifyItemChanged(pokemonMovesList.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonMovesAdapter.PokemonMovesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_moves, parent, false)
        return PokemonMovesViewHolder(view)
    }
    override fun onBindViewHolder(holder: PokemonMovesViewHolder, position: Int) {
        val pokemonMove = pokemonMovesList[position]
        holder.bind(pokemonMove,position,colorData)
    }
    override fun getItemCount(): Int {
        return pokemonMovesList.size
    }
    class PokemonMovesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewMoves: TextView = itemView.findViewById(R.id.textViewMoves)
        private val textViewMovesId: TextView = itemView.findViewById(R.id.textViewIdMoves)
        private  val backgroud : RelativeLayout = itemView.findViewById(R.id.relativeLayoutBackground4)

        fun bind(pokemonMoves: Move, position: Int, colorData: Int) {
            val idContador = position + 1
            textViewMoves.text = pokemonMoves.move!!.name
            textViewMovesId.text = idContador.toString()
            backgroud.setBackgroundColor(colorData)

        }
    }

}
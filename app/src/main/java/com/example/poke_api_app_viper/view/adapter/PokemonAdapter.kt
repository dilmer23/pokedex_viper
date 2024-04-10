import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.utils.GlobalVars



class PokemonAdapter(private val router: PokemonContract.Router) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    private var pokemonList = listOf<Result>()

    fun setData(newList: List<Result>) {
        pokemonList = newList
       notifyItemChanged(pokemonList.size)
    }
    fun setUpdateData(newList: List<Result>) {
        pokemonList = newList
        notifyItemChanged(pokemonList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon,position,router)
    }
    override fun getItemCount(): Int {
        return pokemonList.size
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val textViewName1: TextView = itemView.findViewById(R.id.textViewType1)
        private val textViewName2: TextView = itemView.findViewById(R.id.textViewID)
        private val container: RelativeLayout = itemView.findViewById(R.id.relativeLayoutBackground)
        private val context = itemView.context

        fun bind(pokemon: Result, id: Int,router: PokemonContract.Router) {
            val idContador = id + 1
            container.setOnClickListener {
                //navegar al fragmento PokemonDetailFragmeto y pasar pokemon.url
                router.navigateToFragmentScreen(pokemon.name)

            }
            textViewName1.text = pokemon.name.toString()
            textViewName2.text = "#$idContador"

            val imageUrl = GlobalVars.imgPomemonDetail + idContador + ".png"
            Glide.with(itemView)
                .load(imageUrl)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .into(imageView)
        }
    }

}

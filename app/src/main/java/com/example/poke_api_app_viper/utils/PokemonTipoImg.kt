
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import com.example.poke_api_app_viper.R

class PokemonTipoImg(var context: Context) {

    @SuppressLint("SupportAnnotationUsage", "UseCompatLoadingForDrawables")
    @DrawableRes
    fun getPokemonColor(typeOfPokemon: List<Type>): Drawable {
        val type = typeOfPokemon.getOrNull(0)
        val img = when (type?.type?.name) {
            "grass", "bug" -> R.drawable.planta
            "fire" -> R.drawable.fuego
            "water", -> R.drawable.water
            "fighting", -> R.drawable.volador
            "normal" -> R.drawable.tierra
            "electric", "psychic" -> R.drawable.rayo
            "poison", -> R.drawable.siquico
            "ghost" -> R.drawable.ada
            "bug" -> R.drawable.bicho
            else -> R.drawable.bicho
        }
        return context.resources.getDrawable(img, context.theme)
    }

}

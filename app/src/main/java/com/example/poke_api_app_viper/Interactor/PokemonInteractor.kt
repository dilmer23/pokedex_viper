import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Constructor
import javax.inject.Inject

class PokemonInteractor@Inject constructor()  {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pokeApiService = retrofit.create(PokeApiService::class.java)

    suspend fun getPokemonList(): PokemonEntity {
        return pokeApiService.getPokemonList()
    }
}

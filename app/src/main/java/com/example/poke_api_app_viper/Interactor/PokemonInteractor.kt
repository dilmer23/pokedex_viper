import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonInteractor {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pokeApiService = retrofit.create(PokeApiService::class.java)

    suspend fun getPokemonList(): PokemonEntity {
        return pokeApiService.getPokemonList()
    }
}

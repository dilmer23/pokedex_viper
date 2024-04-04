import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PokeApiService {
    companion object{
        const val pokemonGet = "pokemon?limit=100000&offset=0"
        const val pokemonGetDetail = "pokemon/{id}"
    }
    @GET(pokemonGet)
    suspend fun getPokemonList(): PokemonEntity

    @GET(pokemonGetDetail)
    @Headers("Content-Type:application/json")
    suspend fun getPokemonDetail(
        @Path("id") id : String
    ): PokemonDetailEntity
}

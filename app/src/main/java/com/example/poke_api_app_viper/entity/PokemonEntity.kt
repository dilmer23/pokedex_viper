data class PokemonEntity(
    val count: Long? = null,
    val next: Any? = null,
    val previous: Any? = null,
    val results: List<Result>? = null
)
data class Result (
    val name: String? = null,
    val url: String? = null
)

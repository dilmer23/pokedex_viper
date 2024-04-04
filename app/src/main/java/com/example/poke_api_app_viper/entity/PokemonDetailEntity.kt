data class PokemonDetailEntity (
    var abilities: List<Ability>?,
    var baseExperience: Long?,
    var cries: Cries?,
    var forms: List<Species>?,
    var gameIndices: List<GameIndex>?,
    var height: Long?,
    var heldItems: List<Any?>?,
    var id: Long?,
    var isDefault: Boolean?,
    var locationAreaEncounters: String?,
    var moves: List<Move>?,
    var name: String?,
    var order: Long?,
    var pastAbilities: List<Any?>?,
    var pastTypes: List<Any?>?,
    var species: Species?,
    var sprites: Sprites? ,
    var stats: List<Stat>?,
    var types: List<Type>?,
    var weight: Long?
)

data class Ability (
    val ability: Species? = null,
    val isHidden: Boolean? = null,
    val slot: Long? = null
)

data class Species (
    val name: String? = null,
    val url: String? = null
)

data class Cries (
    val latest: String? = null,
    val legacy: String? = null
)

data class GameIndex (
    val gameIndex: Long? = null,
    val version: Species? = null
)

data class Move (
    val move: Species? = null,
    val versionGroupDetails: List<VersionGroupDetail>? = null
)

data class VersionGroupDetail (
    val levelLearnedAt: Long? = null,
    val moveLearnMethod: Species? = null,
    val versionGroup: Species? = null
)

data class GenerationV (
    val blackWhite: Sprites? = null
)

data class GenerationIv (
    val diamondPearl: Sprites? = null,
    val heartgoldSoulsilver: Sprites? = null,
    val platinum: Sprites? = null
)

data class Versions (
    val generationI: GenerationI? = null,
    val generationIi: GenerationIi? = null,
    val generationIii: GenerationIii? = null,
    val generationIv: GenerationIv? = null,
    val generationV: GenerationV? = null,
    val generationVi: Map<String, Home>? = null,
    val generationVii: GenerationVii? = null,
    val generationViii: GenerationViii? = null
)

data class Other (
    val dreamWorld: DreamWorld? = null,
    val home: Home? = null,
    val officialArtwork: OfficialArtwork? = null,
    val showdown: Sprites? = null
)

data class Sprites (
    val backDefault: String?,
    val backFemale: Any?,
    val backShiny: String?,
    val backShinyFemale: Any?,
    val frontDefault: String? = null,
    val frontFemale: Any? = null,
    val frontShiny: String? = null,
    val frontShinyFemale: Any? = null,
    val other: Other? = null,
    val versions: Versions? = null,
    val animated: Sprites? = null
)

data class GenerationI (
    val redBlue: RedBlue? = null,
    val yellow: RedBlue? = null
)

data class RedBlue (
    val backDefault: String? = null,
    val backGray: String? = null,
    val backTransparent: String? = null,
    val frontDefault: String? = null,
    val frontGray: String? = null,
    val frontTransparent: String? = null
)

data class GenerationIi (
    val crystal: Crystal? = null,
    val gold: Gold? = null,
    val silver: Gold? = null
)

data class Crystal (
    val backDefault: String? = null,
    val backShiny: String? = null,
    val backShinyTransparent: String? = null,
    val backTransparent: String? = null,
    val frontDefault: String? = null,
    val frontShiny: String? = null,
    val frontShinyTransparent: String? = null,
    val frontTransparent: String? = null
)

data class Gold (
    val backDefault: String? = null,
    val backShiny: String? = null,
    val frontDefault: String? = null,
    val frontShiny: String? = null,
    val frontTransparent: String? = null
)

data class GenerationIii (
    val emerald: OfficialArtwork? = null,
    val fireredLeafgreen: Gold? = null,
    val rubySapphire: Gold? = null
)

data class OfficialArtwork (
    val frontDefault: String? = null,
    val frontShiny: String? = null
)

data class Home (
    val frontDefault: String? = null,
    val frontFemale: Any? = null,
    val frontShiny: String? = null,
    val frontShinyFemale: Any? = null
)

data class GenerationVii (
    val icons: DreamWorld? = null,
    val ultraSunUltraMoon: Home? = null
)

data class DreamWorld (
    val frontDefault: String? = null,
    val frontFemale: Any? = null
)

data class GenerationViii (
    val icons: DreamWorld? = null
)

data class Stat (
    val baseStat: Long? = null,
    val effort: Long? = null,
    val stat: Species? = null
)

data class Type (
    val slot: Long? = null,
    val type: Species? = null
)

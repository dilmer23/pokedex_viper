package com.example.poke_api_app_viper.entity

data class PokemonEvolution (
    val babyTriggerItem: Any? = null,
    val chain: Chain? = null,
    val id: Long? = null
)

data class Chain (
    val evolutionDetails: List<EvolutionDetail>? = null,
    val evolvesTo: List<Chain>? = null,
    val isBaby: Boolean? = null,
    val species: Species? = null
)

data class EvolutionDetail (
    val gender: Any? = null,
    val heldItem: Any? = null,
    val item: Any? = null,
    val knownMove: Any? = null,
    val knownMoveType: Any? = null,
    val location: Any? = null,
    val minAffection: Any? = null,
    val minBeauty: Any? = null,
    val minHappiness: Any? = null,
    val minLevel: Long? = null,
    val needsOverworldRain: Boolean? = null,
    val partySpecies: Any? = null,
    val partyType: Any? = null,
    val relativePhysicalStats: Any? = null,
    val timeOfDay: String? = null,
    val tradeSpecies: Any? = null,
    val trigger: Species? = null,
    val turnUpsideDown: Boolean? = null
)

data class Species (
    val name: String? = null,
    val url: String? = null
)
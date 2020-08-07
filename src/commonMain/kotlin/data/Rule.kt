package data

import kotlinx.serialization.Serializable

@Serializable
data class Rule(
    val gender: Gender,
    val test: List<String>,
    val mods: List<Mod>,
    val tags: List<String>? = null
)

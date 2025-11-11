package my.tapEvolution

import kotlinx.serialization.Serializable

@Serializable
data class SavedData(
    val food: Int,
    val wood: Int,
    val stone: Int,
    val population: Int,
    val workers: List<Int>,
    val resourceCaps: List<Int>,
    val popCap: Int,
    val buildings: List<Int>,
    val landFree: Int,
    val territory: Int,
    val warriors: List<Int>,
    val multipliers: List<Double>
)

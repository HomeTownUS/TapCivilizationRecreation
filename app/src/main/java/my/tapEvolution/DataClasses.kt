package my.tapEvolution

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

@Serializable
data class DataClasses(
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
    val multipliers: List<Double>,
    val research: List<ResearchNode>
)

@Serializable
data class ResearchNode(
    val name: String,
    val prerequisites: List<String>,
    val durationMillis: Long,
    val startTimeMillis: Long? = null,
    val isUnlocked: Boolean = false,
    val cost: List<Int>,
    val bg: ULong,
    val isAvailable: Boolean = false
)
package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Name(
    @SerialName("exceptions") val exceptionList: List<Rule>,
    @SerialName("suffixes") val suffixList: List<Rule>
)

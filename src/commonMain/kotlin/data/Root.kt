package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Root(
    @SerialName("firstname") val firstName: Name,
    @SerialName("lastname") val lastName: Name,
    @SerialName("middlename") val middleName: Name
)

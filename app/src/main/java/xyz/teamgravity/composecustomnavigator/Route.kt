package xyz.teamgravity.composecustomnavigator

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object HomeGraph : Route

    @Serializable
    data object AuthGraph : Route

    @Serializable
    data object Home : Route

    @Serializable
    data object Login : Route

    @Serializable
    data class Detail(
        val id: String
    ) : Route
}
package xyz.teamgravity.composecustomnavigator

import androidx.navigation.NavOptionsBuilder

sealed interface NavigationAction {
    data class Navigate(
        val route: Route,
        val options: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationAction

    data object NavigateUp : NavigationAction
}
package xyz.teamgravity.composecustomnavigator

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.Flow

interface Navigator {
    val startRoute: Route
    val navigationActions: Flow<NavigationAction>

    suspend fun navigate(
        route: Route,
        options: NavOptionsBuilder.() -> Unit = {}
    )

    suspend fun navigateUp()
}
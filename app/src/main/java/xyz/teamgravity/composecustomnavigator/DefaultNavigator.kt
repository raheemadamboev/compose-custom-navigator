package xyz.teamgravity.composecustomnavigator

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class DefaultNavigator(
    override val startRoute: Route
) : Navigator {

    private val _navigationActions = Channel<NavigationAction>()
    override val navigationActions: Flow<NavigationAction> = _navigationActions.receiveAsFlow()

    override suspend fun navigate(
        route: Route,
        options: NavOptionsBuilder.() -> Unit
    ) {
        _navigationActions.send(
            NavigationAction.Navigate(
                route = route,
                options = options
            )
        )
    }

    override suspend fun navigateUp() {
        _navigationActions.send(NavigationAction.NavigateUp)
    }
}
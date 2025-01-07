package xyz.teamgravity.composecustomnavigator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(
    private val navigator: Navigator
) : ViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // API
    ///////////////////////////////////////////////////////////////////////////

    fun onLogin() {
        viewModelScope.launch {
            navigator.navigate(
                route = Route.HomeGraph,
                options = {
                    popUpTo(
                        route = Route.AuthGraph,
                        popUpToBuilder = {
                            inclusive = true
                        }
                    )
                }
            )
        }
    }
}
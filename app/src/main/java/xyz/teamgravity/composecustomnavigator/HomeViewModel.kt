package xyz.teamgravity.composecustomnavigator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.uuid.Uuid

class HomeViewModel(
    private val navigator: Navigator
) : ViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // API
    ///////////////////////////////////////////////////////////////////////////

    fun onNavigateToDetail() {
        viewModelScope.launch {
            navigator.navigate(Route.Detail(Uuid.random().toString()))
        }
    }
}
package xyz.teamgravity.composecustomnavigator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DetailViewModel(
    private val navigator: Navigator
) : ViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // API
    ///////////////////////////////////////////////////////////////////////////

    fun onBack() {
        viewModelScope.launch {
            navigator.navigateUp()
        }
    }
}
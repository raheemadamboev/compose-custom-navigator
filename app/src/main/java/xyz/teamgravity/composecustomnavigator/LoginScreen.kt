package xyz.teamgravity.composecustomnavigator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    viewmodel: LoginViewModel = koinViewModel()
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = viewmodel::onLogin
        ) {
            Text(
                text = stringResource(R.string.login)
            )
        }
    }
}
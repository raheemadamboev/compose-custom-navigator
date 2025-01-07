package xyz.teamgravity.composecustomnavigator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewmodel: HomeViewModel = koinViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterVertically
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.home)
        )
        Button(
            onClick = viewmodel::onNavigateToDetail
        ) {
            Text(
                text = stringResource(R.string.go_to_detail)
            )
        }
    }
}
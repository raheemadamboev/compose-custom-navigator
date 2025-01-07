package xyz.teamgravity.composecustomnavigator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.koin.compose.koinInject
import xyz.teamgravity.composecustomnavigator.ui.theme.ComposeCustomNavigatorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCustomNavigatorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    val controller = rememberNavController()
                    val navigator = koinInject<Navigator>()

                    ObserveEvent(
                        flow = navigator.navigationActions,
                        onEvent = { event ->
                            when (event) {
                                is NavigationAction.Navigate -> {
                                    controller.navigate(
                                        route = event.route,
                                        builder = event.options
                                    )
                                }

                                NavigationAction.NavigateUp -> {
                                    controller.navigateUp()
                                }
                            }
                        }
                    )

                    NavHost(
                        navController = controller,
                        startDestination = navigator.startRoute,
                        modifier = Modifier.padding(padding)
                    ) {
                        navigation<Route.AuthGraph>(
                            startDestination = Route.Login
                        ) {
                            composable<Route.Login> {
                                LoginScreen()
                            }
                        }
                        navigation<Route.HomeGraph>(
                            startDestination = Route.Home
                        ) {
                            composable<Route.Home> {
                                HomeScreen()
                            }
                            composable<Route.Detail> { entry ->
                                val route = entry.toRoute<Route.Detail>()
                                DetailScreen(
                                    args = route
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
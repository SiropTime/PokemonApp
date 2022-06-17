package ru.maltsev.pokemonapp.utility

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.maltsev.pokemonapp.screen.Details
import ru.maltsev.pokemonapp.screen.IntroScreen
import ru.maltsev.pokemonapp.screen.MainScreen
import ru.maltsev.pokemonapp.screen.Screen

@Composable
fun SetupNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Intro.route
    ) {
        composable(
            route = Screen.Intro.route
        ) {
            Box(modifier = modifier) {
                IntroScreen(navController = navController)
            }

        }

        composable(
            route = Screen.Main.route
        ) {
            Box(modifier = modifier) {
                MainScreen(navController = navController)
            }

        }

        composable(
            "pokemon/{id}",
            arguments = listOf(navArgument("id") {type = NavType.IntType})
        ) { backStackEntry ->
            Box(modifier = modifier) {
                Details(navController = navController, pokemonId = backStackEntry.arguments?.getInt("id")?: 0)
            }
        }

    }
}
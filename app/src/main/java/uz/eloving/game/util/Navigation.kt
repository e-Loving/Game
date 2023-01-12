package uz.eloving.game.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import uz.eloving.game.page.MainPage
import uz.eloving.game.Screen
import uz.eloving.game.page.LevelPage

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainPage(navController)
        }
        composable(
            route = Screen.LevelScreen.route + "/{option}",
            arguments = listOf(navArgument("option") {
                type = NavType.StringType
                defaultValue = "0"
                nullable = true
            })
        ) { entry ->
            entry.arguments?.getString("option")?.let { LevelPage(option = it) }
        }
    }
}

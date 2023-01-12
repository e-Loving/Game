package uz.eloving.game.util

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object LevelScreen : Screen("level_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
    }
}

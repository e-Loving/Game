package uz.eloving.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.eloving.game.ui.theme.Backgroud
import uz.eloving.game.ui.theme.GameTheme
import uz.eloving.game.util.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setNavigationBarColor(color = Backgroud)
            GameTheme {
                Navigation()
            }
        }
    }
}
package uz.eloving.game.page

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun LevelPage(option: String) {
    Toast.makeText(LocalContext.current, option, Toast.LENGTH_SHORT).show()
}
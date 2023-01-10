package uz.eloving.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.eloving.game.ui.theme.BakBak
import uz.eloving.game.ui.theme.GameTheme

@Composable
fun AppBar() {
    val systemUiController = rememberSystemUiController()
    val painter = painterResource(id = R.drawable.flag)
    systemUiController.setStatusBarColor(color = Color.Transparent)
    ConstraintLayout(
        modifier = Modifier
            .height(110.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)

    ) {
        val (iv_bg, iv_flag_r, iv_flag_l, tv_main, tv_secondary) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = "UpBarBackground",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .constrainAs(iv_bg) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxHeight()
        )
        Image(
            painter = painter,
            contentDescription = "Flag",
            modifier = Modifier
                .aspectRatio(ratio = 0.7f)
                .constrainAs(iv_flag_l) {
                    start.linkTo(iv_bg.start)
                    top.linkTo(iv_bg.top)
                    bottom.linkTo(iv_bg.bottom)
                }
                .padding(30.dp, 30.dp, 0.dp, 0.dp)
                .background(
                    Brush.radialGradient(
                        colors = listOf(Color(0xFFBD3A1B), Color(0x00FFFFFF))
                    )
                )
        )
        Image(
            painter = painter,
            contentDescription = "Flag",
            modifier = Modifier
                .aspectRatio(ratio = 0.7f)
                .constrainAs(iv_flag_r) {
                    end.linkTo(iv_bg.end)
                    top.linkTo(iv_bg.top)
                    bottom.linkTo(iv_bg.bottom)
                }
                .padding(0.dp, 30.dp, 30.dp, 0.dp)
                .background(
                    Brush.radialGradient(
                        colors = listOf(Color(0xFFBD3A1B), Color(0x00FFFFFF))
                    )
                )
                .graphicsLayer { rotationY = 180f }
        )
        Text(
            text = "FLAGS",
            modifier = Modifier
                .constrainAs(tv_main) {
                    start.linkTo(iv_flag_l.end)
                    end.linkTo(iv_flag_r.start)
                    top.linkTo(iv_flag_l.top)
                    bottom.linkTo(iv_flag_l.bottom)
                }
                .padding(30.dp),
            style = TextStyle(color = Color(0xFFFFFFFF), fontSize = 40.sp, fontFamily = BakBak)
        )
        Text(text = "Learn the name of the flags", modifier = Modifier
            .constrainAs(tv_secondary) {
                start.linkTo(tv_main.start)
                end.linkTo(tv_main.end)
                bottom.linkTo(parent.bottom)
            }
            .padding(bottom = 16.dp), style = TextStyle(color = Color(0xFFFFFFFF)))
    }
}

@Preview
@Composable
fun Preview() {
    GameTheme {
        AppBar()
    }
}
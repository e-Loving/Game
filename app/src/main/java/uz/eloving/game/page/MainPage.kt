package uz.eloving.game.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.eloving.game.R
import uz.eloving.game.Screen
import uz.eloving.game.data.MockData
import uz.eloving.game.model.OptionModel
import uz.eloving.game.ui.theme.Backgroud
import uz.eloving.game.ui.theme.BakBak

@Composable
fun MainPage(navController: NavController) {
    var selected by remember { mutableStateOf("1") }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Backgroud)
    ) {
        val (appBar, optionPanel, play) = createRefs()
        Surface(modifier = Modifier
            .constrainAs(appBar) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
            .background(Backgroud)) {
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
                    style = TextStyle(
                        color = Color(0xFFFFFFFF),
                        fontSize = 40.sp,
                        fontFamily = BakBak
                    )
                )
                Text(text = "Learn the name of the flags", modifier = Modifier
                    .constrainAs(tv_secondary) {
                        start.linkTo(tv_main.start)
                        end.linkTo(tv_main.end)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(tv_main.bottom)
                    }
                    .padding(bottom = 26.dp), style = TextStyle(color = Color(0xFFFFFFFF)))
            }
        }
        Surface(
            modifier = Modifier
                .constrainAs(optionPanel) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(appBar.bottom)
                }
                .wrapContentSize()
        ) {
            @Composable
            fun OptionItem(puppy: OptionModel) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .clickable {
                            selected = puppy.id
                        },
                    elevation = 2.dp, shape = RoundedCornerShape(corner = CornerSize(16.dp))
                ) {
                    ConstraintLayout {
                        val (tv_main, tv_secondary, iv_flags) = createRefs()
                        if (puppy.id == selected) Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .constrainAs(iv_flags) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    width = Dimension.fillToConstraints
                                    height = Dimension.fillToConstraints
                                }) {
                            ConstraintLayout {
                                val (iv_flag_l, iv_flag_r) = createRefs()
                                Image(
                                    painter = painterResource(id = R.drawable.ic_info),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .background(Color.Green)
                                        .constrainAs(iv_flag_l) {
                                            start.linkTo(parent.start)
                                            top.linkTo(parent.top)
                                            bottom.linkTo(parent.bottom)
                                        }
                                        .fillMaxHeight()
                                        .width(60.dp)
                                        .padding(10.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_play),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .background(Color.Green)
                                        .constrainAs(iv_flag_r) {
                                            end.linkTo(parent.end)
                                            top.linkTo(parent.top)
                                            bottom.linkTo(parent.bottom)
                                        }
                                        .fillMaxHeight()
                                        .width(60.dp)
                                        .padding(10.dp)
                                )
                            }
                        }
                        Text(
                            text = puppy.name,
                            style = TextStyle(
                                color = Backgroud, fontFamily = BakBak,
                                fontWeight = Bold, fontSize = 30.sp
                            ), modifier = Modifier
                                .constrainAs(tv_main) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    top.linkTo(parent.top)
                                }
                                .padding(top = 8.dp)
                        )
                        Text(
                            text = "Play",
                            style = typography.caption,
                            modifier = Modifier
                                .constrainAs(tv_secondary) {
                                    start.linkTo(tv_main.start)
                                    end.linkTo(tv_main.end)
                                    top.linkTo(tv_main.bottom)
                                }
                                .padding(bottom = 8.dp)
                        )

                    }
                }
            }

            val options = remember { MockData.options }
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                modifier = Modifier.background(Backgroud)
            ) {
                items(
                    items = options,
                    itemContent = {
                        OptionItem(puppy = it)
                    })
            }
        }
        Surface(
            modifier = Modifier
                .constrainAs(play) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(optionPanel.bottom)
                }
                .shadow(0.dp),
            color = Color.Transparent
        ) {
            Button(
                onClick = { navController.navigate(Screen.LevelScreen.withArgs(selected)) },
                shape = RoundedCornerShape(40),
                modifier = Modifier
                    .height(60.dp)
                    .width(160.dp),
                colors = ButtonDefaults.textButtonColors(backgroundColor = Color.Green)
            ) {
                Text(
                    text = "Play",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = BakBak,
                        fontWeight = Bold,
                        fontSize = 30.sp
                    )
                )
            }
        }
    }
}
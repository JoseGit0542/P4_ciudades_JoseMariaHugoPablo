package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.BottomBarState
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

@Composable
fun PantallaInicio(
    onComienzaClick: () -> Unit,
    onObjetoClick: () -> Unit,
    onOpcionesClick: () -> Unit,
    miViewModel: InicioViewModel = viewModel(),
    bottomState: BottomBarState
) {
    val uiState by miViewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {

        Image(
            painter = painterResource(
                if (uiState.isDarkTheme) R.drawable.endermanfondo else R.drawable.fondodia
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(
                    if (uiState.isDarkTheme) R.drawable.endermanfondo else R.drawable.fondodia
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(R.drawable.logoiidiomas2),
                contentDescription = "Cambiar Idioma",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(20.dp)
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { }
                    .padding(5.dp)
            )

            Image(
                painter = painterResource(
                    if (uiState.isDarkTheme) R.drawable.sol else R.drawable.lunaimagen
                ),
                contentDescription = "Cambiar Tema",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(20.dp)
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { miViewModel.toggleTheme() }
                    .padding(5.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.logominecraft),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(0.8f),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            MinecraftPanelDescripcion(
                modifier = Modifier.fillMaxWidth(0.85f),
                isDarkTheme = uiState.isDarkTheme
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                botonMinecraft(stringResource(R.string.boton_comenzar), Modifier.weight(1f)) { onComienzaClick() }
                botonMinecraft(stringResource(R.string.boton_explorar), Modifier.weight(1f)) { onObjetoClick() }
            }
        }

        MinecraftBottomBar(
            state = bottomState,
            onInicioClick = {},
            onBiomasClick = onComienzaClick,
            onCategoriasClick = onObjetoClick,
            onOpcionesClick = onOpcionesClick,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun MinecraftPanelDescripcion(modifier: Modifier = Modifier, isDarkTheme: Boolean) {
    Box(
        modifier = modifier
            .background(grisMinecraftiano)
            .border(3.dp, Color.Black)
            .padding(12.dp)
    ) {
        Text(
            text = stringResource(R.string.descripcionInicio),
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier
                .offset(x = 2.dp, y = 2.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.descripcionInicio),
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun botonMinecraft(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var pressed by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .background(
                if (pressed) grisOscuroMinecraftiano else grisMinecraftiano
            )
            .then(
                if (!pressed) Modifier.border(3.dp, Color.Black)
                else Modifier
            )
            .clickable {
                pressed = !pressed
                onClick()
            }
            .padding(vertical = 10.dp)
    ) {
        textoBotonesInicio(
            text = text,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun textoBotonesInicio(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier
                .offset(x = 1.5.dp, y = 1.5.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color(0xFFFFFF55),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaInicio() {
    val fakeState = BottomBarState(
        inicio = true,
        biomas = true,
        categorias = true,
        opciones = true
    )

    PantallaInicio(
        onComienzaClick = {},
        onObjetoClick = {},
        onOpcionesClick = {},
        bottomState = fakeState
    )
}
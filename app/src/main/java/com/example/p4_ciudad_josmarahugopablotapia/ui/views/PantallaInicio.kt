package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaInicioPreview() {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        // Creamos una versión "falsa" o manual de la pantalla para la vista previa
        PantallaInicio(
            onComienzaClick = { /* No hace nada en preview */ },
            onObjetoClick = { /* No hace nada en preview */ },
            onOpcionesClick = {}
            // El viewModel se creará por defecto, pero como es una Preview
            // mostrará el estado inicial (Día)
        )
    }
}
@Composable
fun PantallaInicio(
    onComienzaClick: () -> Unit,
    onObjetoClick: () -> Unit,
    onOpcionesClick: () -> Unit,

    miViewModel: InicioViewModel = viewModel()
) {
    val uiState by miViewModel.uiState.collectAsState()

    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        Box(modifier = Modifier.fillMaxSize().statusBarsPadding()
            .navigationBarsPadding()) {

            // Fondo
            Image(
                painter = painterResource(
                    if (uiState.isDarkTheme) R.drawable.endermanfondo else R.drawable.fondodia
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Contenedor para logo de idiomas y selector de tema
            Box(modifier = Modifier.fillMaxSize()) {
                // 1. Imagen de Fondo (Se dibuja primero para quedar atrás)
                Image(
                    painter = painterResource(
                        if (uiState.isDarkTheme) R.drawable.endermanfondo else R.drawable.fondodia
                    ),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // 2. Logo de Idiomas (Arriba a la Izquierda)
                Image(
                    painter = painterResource(R.drawable.logoiidiomas2),
                    contentDescription = "Cambiar Idioma",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(20.dp)
                        .size(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { /* Acción de idiomas */ }
                        .padding(5.dp)
                )
                // 3. Selector de Tema (Arriba a la Derecha)
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

            // --- Contenido Central ---
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Logo de Minecraft
                Image(
                    painter = painterResource(R.drawable.logominecraft),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth(0.8f),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(20.dp))

                // 1. CAJA DE DESCRIPCIÓN (Ancho 0.85f)
                MinecraftPanelDescripcion(
                    modifier = Modifier.fillMaxWidth(0.85f),
                    isDarkTheme = uiState.isDarkTheme
                )

                Spacer(modifier = Modifier.height(10.dp))

                // 2. FILA DE BOTONES (Ajustada a 0.85f para coincidir con el panel de arriba)
                Row(
                    modifier = Modifier.fillMaxWidth(0.85f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    botonMinecraft("Comenzar", Modifier.weight(1f)) { onComienzaClick() }
                    botonMinecraft("Explorar", Modifier.weight(1f)) { onObjetoClick() }
                }
            }

            // --- BARRA INFERIOR ---
            MinecraftBottomBar(
                mostrarInicio = false,
                onBiomasClick = onComienzaClick,
                onCategoriasClick = onObjetoClick,
                onOpcionesClick = onOpcionesClick,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            )
        }
    }
}
// --- Componentes de UI (Sin cambios lógicos, solo visuales) ---

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
            color = Color.White,  // dorado tipo Minecraft
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




//en vez de usar minecraftTextDay usamos esto porque queremos que los colores de los botones
//sean siempre amarillos
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


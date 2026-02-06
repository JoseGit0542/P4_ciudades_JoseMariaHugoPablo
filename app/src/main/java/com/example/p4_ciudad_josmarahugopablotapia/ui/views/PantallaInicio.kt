package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel



@Composable
fun PantallaInicio(
    onComienzaClick: () -> Unit,
    onObjetoClick: () -> Unit,
    // Cambiamos el nombre de la variable para evitar confusiones
    miViewModel: InicioViewModel = viewModel()
) {
    // El estado fluye hacia abajo (State down)
    val uiState by miViewModel.uiState.collectAsState()

    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            // Fondo cambia según el estado del ViewModel
            Image(
                painter = painterResource(
                    if (uiState.isDarkTheme) R.drawable.fondo_noche else R.drawable.fondodia
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Selector de tema (Luna/Sol)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(
                        if (uiState.isDarkTheme) R.drawable.sol else R.drawable.lunaimagen
                    ),
                    contentDescription = "Cambiar Tema",
                    modifier = Modifier
                        .padding(20.dp)
                        .size(50.dp)
                        .shadow(4.dp, RoundedCornerShape(8.dp))
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { miViewModel.toggleTheme() } // El evento sube (Event up)
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
                Image(
                    painter = painterResource(R.drawable.logominecraft),
                    contentDescription = "Logo",
                    modifier = Modifier.height(100.dp).fillMaxWidth(0.8f),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(20.dp))

                MinecraftPanel(modifier = Modifier.fillMaxWidth(0.85f)) {
                    MinecraftTextDay("Explora el mundo pixelado")
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    MinecraftButton("Comenzar", Modifier.weight(1f)) { onComienzaClick() }
                    Spacer(modifier = Modifier.width(10.dp))
                    MinecraftButton("Explorar", Modifier.weight(1f)) { onObjetoClick() }
                }
            }
        }
    }
}
// --- Componentes de UI (Sin cambios lógicos, solo visuales) ---

@Composable
fun MinecraftPanel(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .background(Color(0xFFA0A0A0))
            .border(3.dp, Color.Black)
            .padding(12.dp)
    ) {
        content()
    }
}

@Composable
fun MinecraftButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(Color(0xFFA0A0A0))
            .border(3.dp, Color.Black)
            .clickable { onClick() }
            .padding(vertical = 10.dp)
    ) {
        MinecraftButtonText(text = text, modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun MinecraftTextDay(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier.offset(x = 2.dp, y = 2.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MinecraftButtonText(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier.offset(x = 1.5.dp, y = 1.5.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = MinecraftFont,
            color = Color(0xFFFFFF55),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}
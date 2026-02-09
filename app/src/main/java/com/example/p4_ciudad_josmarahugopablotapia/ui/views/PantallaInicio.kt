package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Chalet
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.barraArriba
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaInicioPreview() {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        // Creamos una versión "falsa" o manual de la pantalla para la vista previa
        PantallaInicio(
            onComienzaClick = { /* No hace nada en preview */ },
            onObjetoClick = { /* No hace nada en preview */ }
            // El viewModel se creará por defecto, pero como es una Preview
            // mostrará el estado inicial (Día)
        )
    }
}
@Composable
fun PantallaInicio(
    onComienzaClick: () -> Unit,
    onObjetoClick: () -> Unit,
    miViewModel: InicioViewModel = viewModel()
) {
    val uiState by miViewModel.uiState.collectAsState()

    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            // Fondo
            Image(
                painter = painterResource(
                    if (uiState.isDarkTheme) R.drawable.endermanfondo else R.drawable.fondodia
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // --- BARRA SUPERIOR ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp) // espacio desde bordes
            ) {
                barraArriba(
                    modifier = Modifier.fillMaxWidth(),
                    isDarkTheme = uiState.isDarkTheme,
                    miViewModel = miViewModel
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
                MinecraftPanelDescripcion(modifier = Modifier.fillMaxWidth(0.85f), isDarkTheme = uiState.isDarkTheme)


                Spacer(modifier = Modifier.height(10.dp)) // Espacio reducido para parecerse a la UI original

                // 2. FILA DE BOTONES (Ajustada a 0.85f para coincidir con el panel de arriba)
                Row(
                    modifier = Modifier.fillMaxWidth(0.85f), // <--- CAMBIO CLAVE AQUÍ
                    horizontalArrangement = Arrangement.spacedBy(8.dp) // Espacio controlado entre botones
                ) {
                    MinecraftButton("Comenzar", Modifier.weight(1f)) { onComienzaClick() }
                    MinecraftButton("Explorar", Modifier.weight(1f)) { onObjetoClick() }
                }
            }

        }
        // --- BARRA INFERIOR CORREGIDA ---
        // --- BARRA INFERIOR CON ICONBUTTONS ---
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            // La imagen de la barra de Minecraft se queda al fondo
            Image(
                painter = painterResource(R.drawable.barradeabajo),
                contentDescription = "Hotbar",
                modifier = Modifier
                    .height(80.dp)
                    .border(3.dp, color = Color.Black), // Un poco más alta para los IconButton
                contentScale = ContentScale.FillBounds,

            )

            MinecraftBottomBar(
                onInicioClick = {},
                onBiomasClick = {},
                onCategoriasClick = {},
                onOpcionesClick = {},
                modifier = Modifier
            );
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
fun MinecraftPanelDescripcion(modifier: Modifier = Modifier, isDarkTheme: Boolean) {
    Box(
        modifier = modifier
            .background(Color(0xFFA0A0A0))
            .border(3.dp, Color.Black)
            .padding(12.dp)
    ) {
        Text(
            text = stringResource(DataSource.descripcion),
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier
                .offset(x = 2.dp, y = 2.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(DataSource.descripcion),
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.White,  // dorado tipo Minecraft
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
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
fun MinecraftTextDay(text: String, modifier: Modifier = Modifier, isDarkTheme: Boolean
) {
    Box(modifier = modifier) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier
                .offset(x = 2.dp, y = 2.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = if (isDarkTheme) Color(0xFFEFE27A) else Color.White,  // dorado tipo Minecraft
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


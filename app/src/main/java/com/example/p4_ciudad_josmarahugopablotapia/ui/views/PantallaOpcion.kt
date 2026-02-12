package com.example.p4_ciudad_josmarahugopablotapia.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.example.p4_ciudad_josmarahugopablotapia.R
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource
import com.example.p4_ciudad_josmarahugopablotapia.data.Detalle
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.BarraArriba
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.BottomBarState
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.TarjetaObjeto
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.textoMinecraftDescripciones
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.textoMinecraftTitulos
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.amarilloMaincraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

// ... (mismos imports anteriores)

@Composable
fun PantallaOpcion(
    biomaId: Int,
    categoriaId: Int,
    onNavigateBack: () -> Unit = {},
    onInicioClick: () -> Unit = {},
    onBiomasClick: () -> Unit = {},
    onCategoriasClick: () -> Unit = {},
    miViewModel: InicioViewModel = viewModel(),
    bottomState: BottomBarState
) {
    val uiState by miViewModel.uiState.collectAsState()
    var selectedValue by rememberSaveable { mutableStateOf<Detalle?>(null) }

    // Lógica de obtención de datos
    val detalles = if (biomaId == -1 && categoriaId == -1) {
        DataSource.obtenerTodosLosDetalles()
    } else {
        DataSource.obtenerDetalles(biomaId, categoriaId)
    }

    // Título dinámico
    val titulo = "Minecraft" // Aquí puedes poner la lógica del título que tenías

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        // Fondo
        Image(
            painter = painterResource(if (uiState.isDarkTheme) R.drawable.endermanfondo else R.drawable.fondodia),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 90.dp)
        ) {
            BarraArriba(titulo = titulo, isDarkTheme = uiState.isDarkTheme, miViewModel = miViewModel)

            Spacer(modifier = Modifier.height(16.dp))

            // LISTA DE OBJETOS USANDO LA NUEVA CARTA
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f) // Importante el weight para que los botones queden abajo
            ) {
                items(detalles) { detalle ->
                    TarjetaObjeto(
                        detalle = detalle,
                        isSelected = selectedValue == detalle,
                        isDarkTheme = uiState.isDarkTheme,
                        onSelect = { selectedValue = detalle }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // BOTONES DE ACCIÓN
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BotonMinecraft(
                    texto = stringResource(R.string.boton_cancelar),
                    onClick = onNavigateBack,
                    enabled = true
                )
                BotonMinecraft(
                    texto = stringResource(R.string.boton_confirmar),
                    onClick = { if (selectedValue != null) onNavigateBack() },
                    enabled = selectedValue != null
                )
            }
        }

        MinecraftBottomBar(
            state = bottomState,
            onInicioClick = onInicioClick,
            onBiomasClick = onBiomasClick,
            onCategoriasClick = onCategoriasClick,
            onOpcionesClick = {},
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

// Pequeño componente auxiliar para no repetir código de botones
@Composable
fun RowScope.BotonMinecraft(texto: String, onClick: () -> Unit, enabled: Boolean) {
    Surface(
        modifier = Modifier
            .weight(1f)
            .clickable(enabled = enabled) { onClick() },
        color = if (enabled) Color(0xFFFFD700) else Color.Gray,
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        textoMinecraftTitulos(
            text = texto,
            isDarkTheme = false,
            modifier = Modifier.padding(12.dp)
        )
    }
}
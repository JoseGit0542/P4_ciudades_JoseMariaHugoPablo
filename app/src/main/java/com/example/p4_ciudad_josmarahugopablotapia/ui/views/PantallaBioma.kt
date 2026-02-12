package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.BarraArriba
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.BottomBarState
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.TarjetaBioma
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

@Composable
fun PantallaBioma(
    windowSize: WindowWidthSizeClass,
    miViewModel: InicioViewModel = viewModel(),
    onNavegar: (Int) -> Unit,
    onInicioClick: () -> Unit,
    onCategoriasClick: () -> Unit,
    onOpcionesClick: () -> Unit,
    bottomState: BottomBarState
) {
    val uiState by miViewModel.uiState.collectAsState()

    // LÓGICA CODELAB: Definir columnas según el ancho de pantalla
    val columnas = when (windowSize) {
        WindowWidthSizeClass.Compact -> 1 // Móvil vertical
        else -> 2 // Tablet o Móvil horizontal
    }

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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BarraArriba(
                titulo = stringResource(R.string.elegirBioma),
                isDarkTheme = uiState.isDarkTheme,
                miViewModel = miViewModel
            )

            Spacer(modifier = Modifier.height(16.dp))

            // CAMBIO: De LazyColumn a LazyVerticalGrid
            LazyVerticalGrid(
                columns = GridCells.Fixed(columnas),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp) // Espacio para la barra inferior
            ) {
                items(DataSource.biomas) { bioma ->
                    TarjetaBioma(
                        titulo = stringResource(bioma.nombreResId),
                        imagenResId = bioma.imagenResId,
                        descripcion = stringResource(bioma.descripcionResId),
                        onTextoClick = { onNavegar(bioma.id) },
                        miViewModel = miViewModel
                    )
                }
            }
        }

        MinecraftBottomBar(
            state = bottomState,
            onInicioClick = onInicioClick,
            onBiomasClick = {},
            onCategoriasClick = onCategoriasClick,
            onOpcionesClick = onOpcionesClick,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
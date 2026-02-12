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
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.CategoriaCard
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

// ... tus imports ...
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

@Composable
fun PantallaCategoria(
    windowSize: WindowWidthSizeClass,
    biomaId: Int,
    onNavegar: (Int) -> Unit,
    onInicioClick: () -> Unit,
    onBiomasClick: () -> Unit,
    onOpcionesClick: () -> Unit,
    miViewModel: InicioViewModel = viewModel(),
    bottomState: BottomBarState
) {
    val uiState by miViewModel.uiState.collectAsState()

    // Lógica del Codelab: 1 columna en móvil, 2 columnas en tablet/horizontal
    val columnas = when (windowSize) {
        WindowWidthSizeClass.Compact -> 1
        else -> 2
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
                titulo = stringResource(R.string.elegirCategoria),
                isDarkTheme = uiState.isDarkTheme,
                miViewModel = miViewModel
            )

            Spacer(modifier = Modifier.height(16.dp))

            // CAMBIO: Usamos LazyVerticalGrid con CategoriaCard
            LazyVerticalGrid(
                columns = GridCells.Fixed(columnas),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(bottom = 80.dp) // Espacio para la BottomBar
            ) {
                items(DataSource.categorias) { categoria ->
                    // Llamamos correctamente a CategoriaCard
                    CategoriaCard(
                        titulo = stringResource(categoria.nombreResId),
                        imagenResId = categoria.imagenResId,
                        descripcion = stringResource(categoria.descripcionResId),
                        onTextoClick = { onNavegar(categoria.id) },
                        miViewModel = miViewModel
                    )
                }
            }
        }

        MinecraftBottomBar(
            state = bottomState,
            onInicioClick = onInicioClick,
            onBiomasClick = onBiomasClick,
            onCategoriasClick = {},
            onOpcionesClick = onOpcionesClick,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
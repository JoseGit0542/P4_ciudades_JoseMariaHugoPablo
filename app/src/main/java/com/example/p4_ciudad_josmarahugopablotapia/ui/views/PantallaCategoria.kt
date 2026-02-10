package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.animation.animateContentSize
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
import com.example.p4_ciudad_josmarahugopablotapia.data.Categoria
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.BarraArriba
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.CategoriaCard
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.amarilloMaincraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

// ---------------------- Card de Categoría ----------------------


@Composable
fun PantallaCategoria(
    onNavegar: (String) -> Unit,
    onInicioClick: () -> Unit,
    onBiomasClick: () -> Unit,
    onOpcionesClick: () -> Unit,
    miViewModel: InicioViewModel = viewModel()
) {
    val uiState by miViewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        // Fondo
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
                .padding(bottom = 90.dp)
        ) {
            BarraArriba(
                titulo = stringResource(R.string.elegirCategoria),
                isDarkTheme = uiState.isDarkTheme,
                miViewModel = miViewModel
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                items(DataSource.categorias) { categoria: Categoria ->
                    // 🔹 Resolvemos el string aquí, dentro del Composable
                    val tituloTexto = stringResource(categoria.nombreResId)

                    CategoriaCard(
                        titulo = tituloTexto,
                        imagenResId = categoria.imagenResId,
                        descripcion = categoria.descripcion,
                        onTextoClick = { onNavegar(tituloTexto) },
                        miViewModel = miViewModel

                        // lambda normal, sin @Composable
                    )
                }
            }

        }

        MinecraftBottomBar(
            onInicioClick = onInicioClick,
            onBiomasClick = onBiomasClick,
            mostrarCategorias = false,
            onOpcionesClick = onOpcionesClick,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

// ---------------------- Preview ----------------------
@Preview(showSystemUi = true)
@Composable
fun PreviewPantallaCategoria() {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        PantallaCategoria(
            onNavegar = {},
            onInicioClick = {},
            onBiomasClick = {},
            onOpcionesClick = {}
        )
    }
}

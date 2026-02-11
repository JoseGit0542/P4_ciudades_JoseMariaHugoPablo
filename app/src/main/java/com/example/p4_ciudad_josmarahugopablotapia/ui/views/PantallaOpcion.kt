package com.example.p4_ciudad_josmarahugopablotapia.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.BarraArriba
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

@Composable
fun PantallaDetalles(
    biomaId: Int,
    categoriaId: Int,
    onNavigateBack: () -> Unit = {},
    onInicioClick: () -> Unit = {},
    onBiomasClick: () -> Unit = {},
    onCategoriasClick: () -> Unit = {},
    miViewModel: InicioViewModel = viewModel()
) {
    val uiState by miViewModel.uiState.collectAsState()
    val isDarkTheme = uiState.isDarkTheme

    val detalles = DataSource.obtenerDetalles(biomaId, categoriaId)

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
                titulo = "Detalles",
                isDarkTheme = isDarkTheme,
                miViewModel = miViewModel
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(detalles) { detalle ->
                    // Cada tarjeta
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(2.dp, Color.White, RoundedCornerShape(8.dp))
                            .clickable { /* opcional: acción al click */ },
                        shape = RoundedCornerShape(8.dp),
                        color = if (isDarkTheme) grisOscuroMinecraftiano else grisMinecraftiano,
                        shadowElevation = 4.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            // Imagen
                            Image(
                                painter = painterResource(detalle.imagenResId),
                                contentDescription = detalle.nombre,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Nombre
                            Text(
                                text = detalle.nombre,
                                fontSize = 20.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            // Descripción
                            Text(
                                text = detalle.descripcion,
                                fontSize = 16.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }

        MinecraftBottomBar(
            onInicioClick = onInicioClick,
            onBiomasClick = onBiomasClick,
            onOpcionesClick = onCategoriasClick,
            mostrarCategorias = true,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPantallaDetalles() {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        PantallaDetalles(
            biomaId = DataSource.BIOMA_SETAS,
            categoriaId = DataSource.CAT_CRIATURAS,
            onNavigateBack = {},
            onInicioClick = {},
            onBiomasClick = {},
            onCategoriasClick = {}
        )
    }
}

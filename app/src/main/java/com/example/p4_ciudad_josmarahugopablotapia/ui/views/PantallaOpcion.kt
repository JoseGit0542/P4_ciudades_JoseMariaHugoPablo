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
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.amarilloMaincraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

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
    val isDarkTheme = uiState.isDarkTheme

    val detalles = if (biomaId == -1 && categoriaId == -1) {
        DataSource.obtenerTodosLosDetalles()
    } else {
        DataSource.obtenerDetalles(biomaId, categoriaId)
    }

    val biomaNombre = DataSource.biomas
        .firstOrNull { it.id == biomaId }
        ?.nombreResId
        ?.let { stringResource(it) }
        ?: ""

    val categoriaNombre = DataSource.categorias
        .firstOrNull { it.id == categoriaId }
        ?.nombreResId
        ?.let { stringResource(it) }
        ?: ""

    val titulo = when {
        biomaId == -1 && categoriaId == -1 -> stringResource(R.string.todos_los_elementos)
        biomaId == -1 -> categoriaNombre
        categoriaId == -1 -> biomaNombre
        else -> "$biomaNombre - $categoriaNombre"
    }

    var selectedValue by rememberSaveable { mutableStateOf<Detalle?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {

        Image(
            painter = painterResource(if (isDarkTheme) R.drawable.endermanfondo else R.drawable.fondodia),
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
                titulo = titulo,
                isDarkTheme = isDarkTheme,
                miViewModel = miViewModel
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(detalles) { detalle ->

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedValue = detalle },
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(2.dp, Color.White),
                        color = if (selectedValue == detalle)
                            Color(0xFFFFD700)
                        else if (isDarkTheme)
                            grisOscuroMinecraftiano
                        else
                            grisMinecraftiano,
                        shadowElevation = 4.dp
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(detalle.imagenResId),
                                contentDescription = stringResource(detalle.nombreResId),
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(6.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = stringResource(detalle.nombreResId),
                                    fontSize = 18.sp,
                                    color = if (uiState.isDarkTheme) amarilloMaincraftiano else Color.White
                                )
                                Text(
                                    text = stringResource(detalle.descripcionResId),
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onNavigateBack() },
                    color = Color(0xFFFFD700),
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, Color.Black)
                ) {
                    Text(
                        text = stringResource(R.string.boton_cancelar),
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }

                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { if (selectedValue != null) onNavigateBack() },
                    color = if (selectedValue != null) Color(0xFFFFD700) else Color.Gray,
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, Color.Black)
                ) {
                    Text(
                        text = stringResource(R.string.boton_confirmar),
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
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
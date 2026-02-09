package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Chalet
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Image
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
import com.example.p4_ciudad_josmarahugopablotapia.data.OrderUiState
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.barraArriba
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.amarilloMaincraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

// ---------------------- Card de Bioma ----------------------
@Composable
fun CategoriaCard(
    titulo: String,
    imagenResId: Int,
    descripcion: String,
    onTextoClick: () -> Unit,
    miViewModel: InicioViewModel = viewModel()
) {
    var expandido by remember { mutableStateOf(false) }
    val uiState by miViewModel.uiState.collectAsState()


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onTextoClick() }
            .animateContentSize(), // para animar la expansión
        color = if(uiState.isDarkTheme) grisOscuroMinecraftiano else grisMinecraftiano, // fondo oscuro estilo AffirmationCard
        shape = RoundedCornerShape(4.dp),
        shadowElevation = 2.dp,
        border = BorderStroke(2.dp, Color.White)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            // ---------- TÍTULO ----------
            Text(
                text = titulo,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = if (uiState.isDarkTheme) amarilloMaincraftiano else Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ---------- IMAGEN ----------
            Image(
                painter = painterResource(imagenResId),
                contentDescription = titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { expandido = !expandido },
                contentScale = ContentScale.Crop
            )

            // ---------- DESCRIPCIÓN EXPANDIDA ----------
            if (expandido) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = descripcion,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


// ---------------------- Pantalla Biomas ----------------------
@Composable
fun PantallaCategoria(
    onNavegar: (String) -> Unit,
    miViewModel: InicioViewModel = viewModel()
) {
    val uiState by miViewModel.uiState.collectAsState()

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

        // ---------------- CONTENIDO SUPERIOR ----------------
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 90.dp) // 👈 espacio reservado para la barra
        ) {

            // Iconos arriba
            barraArriba(
                modifier = Modifier,
                isDarkTheme = uiState.isDarkTheme,
                miViewModel = miViewModel
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource( R.string.elegirCategoria),
                fontSize = 28.sp,
                color = if (uiState.isDarkTheme) Color.White else Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            val Categorias = listOf(
                Triple("mobs", R.drawable.mobs, "Criaturas hostiles y no hostiles"),
                Triple("objetos", R.drawable.items, "Elemento que existe en las manos y en el inventario del jugador "),
                Triple("estructuras", R.drawable._35px_21w07a_mineshaft, "Construcciones generadas automaticamente"),
                Triple("vegetacion", R.drawable.vegetacion, "Generada segun el bioma, con amplias variedades")
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(Categorias) { bioma ->
                    CategoriaCard(
                        titulo = bioma.first,
                        imagenResId = bioma.second,
                        descripcion = bioma.third,
                        onTextoClick = { onNavegar(bioma.first) }
                    )
                }
            }
        }

        // ---------------- BARRA INFERIOR FIJA ----------------
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.barradeabajo),
                contentDescription = "Hotbar",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            MinecraftBottomBar(
                onInicioClick = {},
                onBiomasClick = {},
                onCategoriasClick = {},
                onOpcionesClick = {},
                modifier = Modifier
            )
        }
    }
}

// ---------------------- Preview ----------------------
@Preview(showSystemUi = true)
@Composable
fun PreviewPantallaCategoria() {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        PantallaCategoria(onNavegar = {})
    }
}

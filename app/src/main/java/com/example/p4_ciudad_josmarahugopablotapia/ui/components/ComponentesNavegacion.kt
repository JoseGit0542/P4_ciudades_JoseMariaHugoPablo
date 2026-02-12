package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Chalet
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.p4_ciudad_josmarahugopablotapia.R

@Composable
fun BotonPagina(
    icon: ImageVector,
    habilitado: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colorActivo = Color.White
    val colorDesactivado = Color(0xFF9E9E9E)

    IconButton(
        onClick = onClick,
        enabled = habilitado,
        modifier = modifier
            .size(60.dp)
            .border(
                width = 2.dp,
                color = if (habilitado) colorActivo else colorDesactivado,
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Navegación",
            tint = if (habilitado) colorActivo else colorDesactivado,
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun MinecraftBottomBar(
    state: BottomBarState,
    onInicioClick: () -> Unit = {},
    onBiomasClick: () -> Unit = {},
    onCategoriasClick: () -> Unit = {},
    onOpcionesClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        Image(
            painter = painterResource(R.drawable.barradeabajo),
            contentDescription = "Barra de navegación",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            BotonPagina(
                icon = Icons.Default.Chalet,
                habilitado = state.inicio,
                onClick = onInicioClick
            )

            BotonPagina(
                icon = Icons.Default.Image,
                habilitado = state.biomas,
                onClick = onBiomasClick
            )

            BotonPagina(
                icon = Icons.Default.Category,
                habilitado = state.categorias,
                onClick = onCategoriasClick
            )

            BotonPagina(
                icon = Icons.Default.ClearAll,
                habilitado = state.opciones,
                onClick = onOpcionesClick
            )
        }
    }
}
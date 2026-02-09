package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Chalet
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Home
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
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(60.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(60.dp)
                .padding(bottom = 10.dp)
        )
    }
}

@Composable
fun MinecraftBottomBar(
    onInicioClick: () -> Unit,
    onBiomasClick: () -> Unit,
    onCategoriasClick: () -> Unit,
    onOpcionesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        // Imagen de fondo de la barra
        androidx.compose.foundation.Image(
            painter = painterResource(R.drawable.barradeabajo),
            contentDescription = "Hotbar",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        // Fila de botones
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 1. Inicio (Chalet icon)
            BotonPagina(Icons.Default.Home, onClick = onInicioClick)

            // 2. Biomas (Image icon)
            BotonPagina(Icons.Default.Image, onClick = onBiomasClick)

            // 3. Categorías (Category icon)
            BotonPagina(Icons.Default.Category, onClick = onCategoriasClick)

            // 4. Opciones (ClearAll icon)
            BotonPagina(Icons.Default.ClearAll, onClick = onOpcionesClick)
        }
    }
}
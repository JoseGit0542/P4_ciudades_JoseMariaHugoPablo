package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier.size(60.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Navegación",
            tint = Color.White,
            modifier = Modifier
                .size(60.dp)
                .padding(bottom = 20.dp)
        )
    }
}

@Composable
fun MinecraftBottomBar(
    mostrarInicio: Boolean = true,
    mostrarBiomas: Boolean = true,
    mostrarCategorias: Boolean = true,
    mostrarOpciones: Boolean = true,
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
    ) {
        // Fondo de la barra Minecraft
        Image(
            painter = painterResource(R.drawable.barradeabajo),
            contentDescription = "Barra de navegación",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        // Botones de navegación
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (mostrarInicio) {
                BotonPagina(
                    icon = Icons.Default.Chalet,
                    onClick = onInicioClick
                )
            } else {
                Spacer(modifier = Modifier.size(60.dp))
            }

            if (mostrarBiomas) {
                BotonPagina(
                    icon = Icons.Default.Image,
                    onClick = onBiomasClick
                )
            } else {
                Spacer(modifier = Modifier.size(60.dp))
            }

            if (mostrarCategorias) {
                BotonPagina(
                    icon = Icons.Default.Category,
                    onClick = onCategoriasClick
                )
            } else {
                Spacer(modifier = Modifier.size(60.dp))
            }

            if (mostrarOpciones) {
                BotonPagina(
                    icon = Icons.Default.ClearAll,
                    onClick = onOpcionesClick
                )
            } else {
                Spacer(modifier = Modifier.size(60.dp))
            }
        }
    }
}
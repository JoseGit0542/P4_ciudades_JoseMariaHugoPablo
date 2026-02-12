package com.example.p4_ciudad_josmarahugopablotapia.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.p4_ciudad_josmarahugopablotapia.data.Detalle
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano

@Composable
fun TarjetaObjeto(
    detalle: Detalle,
    isSelected: Boolean,
    isDarkTheme: Boolean,
    onSelect: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, if (isSelected) Color.Black else Color.White),
        color = if (isSelected)
            Color(0xFFFFD700) // Amarillo si está seleccionado
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
                textoMinecraftTitulos(
                    text = stringResource(detalle.nombreResId),
                    isDarkTheme = isDarkTheme && !isSelected, // Si está seleccionado, mejor texto oscuro
                    modifier = Modifier.fillMaxWidth()
                )
                textoMinecraftDescripciones(
                    text = stringResource(detalle.descripcionResId),
                    isDarkTheme = isDarkTheme && !isSelected,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
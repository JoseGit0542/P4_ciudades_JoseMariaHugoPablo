package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

@Composable
fun CategoriaCard(
    titulo: String,
    imagenResId: Int,
    descripcion: String,
    onTextoClick: () -> Unit,
    miViewModel: InicioViewModel  // sin '= viewModel()' ni nada  // <--- importante
) {
    var expandido by remember { mutableStateOf(false) }
    val uiState by miViewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onTextoClick() }
            .animateContentSize(),
        color = if (uiState.isDarkTheme) grisOscuroMinecraftiano else grisMinecraftiano,
        shape = RoundedCornerShape(4.dp),
        shadowElevation = 2.dp,
        border = BorderStroke(2.dp, Color.White)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            textoMinecraftTitulos(titulo, isDarkTheme = uiState.isDarkTheme)

            Spacer(modifier = Modifier.height(8.dp))

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

            if (expandido) {
                Spacer(modifier = Modifier.height(8.dp))
                textoMinecraftDescripciones(
                    text = descripcion,
                    isDarkTheme = uiState.isDarkTheme,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
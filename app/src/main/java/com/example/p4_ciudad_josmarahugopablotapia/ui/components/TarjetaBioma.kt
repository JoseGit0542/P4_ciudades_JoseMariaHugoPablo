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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

@Composable
fun TarjetaBioma(
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
            .padding(4.dp)
            .animateContentSize(), // animación de expansión
        color = if (uiState.isDarkTheme) grisOscuroMinecraftiano else grisMinecraftiano,
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 2.dp,
        border = BorderStroke(2.dp, Color.White)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            // ---------- TÍTULO ----------
            textoMinecraftTitulos(titulo, isDarkTheme = uiState.isDarkTheme)

            Spacer(modifier = Modifier.height(8.dp))

            // ---------- IMAGEN ----------
            Image(
                painter = painterResource(imagenResId),
                contentDescription = titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { expandido = !expandido },   // 🔹 Solo expande
                contentScale = ContentScale.Crop
            )

            // ---------- DESCRIPCIÓN + BOTÓN ----------
            if (expandido) {
                Spacer(modifier = Modifier.height(8.dp))

                textoMinecraftDescripciones(
                    text = descripcion,
                    isDarkTheme = uiState.isDarkTheme,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // 🔹 BOTÓN MINECRAFT PARA NAVEGAR
                Surface(
                    color = Color(0xFFFFD700), // amarillo Minecraft
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onTextoClick() }
                ) {
                    Text(
                        text = "Ver más",
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }
        }
    }
}

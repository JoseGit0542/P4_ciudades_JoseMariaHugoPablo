package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudad_josmarahugopablotapia.R
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

@Composable
fun BarraArriba(
    modifier: Modifier = Modifier,
    titulo: String? = null,
    isDarkTheme: Boolean,
    miViewModel: InicioViewModel = viewModel()
) {
    val context = LocalContext.current
    val uiState by miViewModel.uiState.collectAsState()

    // Cargar idiomas disponibles SOLO UNA VEZ
    LaunchedEffect(Unit) {
        miViewModel.cargarIdiomasDisponibles(context)
        miViewModel.obtenerIdiomaActual(context)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botón de idioma - AL PULSAR CAMBIA AL SIGUIENTE IDIOMA
        Image(
            painter = painterResource(R.drawable.logoiidiomas2),
            contentDescription = "Cambiar Idioma",
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    miViewModel.cambiarAlSiguienteIdioma(context)

                    // Forzar recreación de la actividad para aplicar cambios
                    Handler(Looper.getMainLooper()).postDelayed({
                        val activity = context as? androidx.activity.ComponentActivity
                        activity?.recreate()
                    }, 100)
                }
        )

        if (titulo != null) {
            Text(
                text = titulo,
                fontSize = 24.sp,
                color = if (isDarkTheme) Color.White else Color.Black,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }

        Image(
            painter = painterResource(if (isDarkTheme) R.drawable.sol else R.drawable.lunaimagen),
            contentDescription = "Cambiar Tema",
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { miViewModel.toggleTheme() }
        )
    }
}
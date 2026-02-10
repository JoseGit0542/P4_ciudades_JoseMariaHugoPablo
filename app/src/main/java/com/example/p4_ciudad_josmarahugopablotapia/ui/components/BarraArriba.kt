package com.example.p4_ciudad_josmarahugopablotapia.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_ciudad_josmarahugopablotapia.R
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

@Composable
fun BarraArriba(
    modifier: Modifier = Modifier,
    titulo: String? = null, // ✅ título opcional
    isDarkTheme: Boolean,
    miViewModel: InicioViewModel
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.logoiidiomas2),
            contentDescription = "Idioma",
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { }
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
            contentDescription = "Tema",
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { miViewModel.toggleTheme() }
        )
    }
}


package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.p4_ciudad_josmarahugopablotapia.R
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

@Composable
fun barraArriba(modifier: Modifier, isDarkTheme: Boolean, miViewModel: InicioViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(R.drawable.logoiidiomas2),
            contentDescription = "Idioma",
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { }
        )

        Image(
            painter = painterResource(
                if (isDarkTheme) R.drawable.sol else R.drawable.lunaimagen
            ),
            contentDescription = "Tema",
            modifier = Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { miViewModel.toggleTheme() }
        )
    }
}

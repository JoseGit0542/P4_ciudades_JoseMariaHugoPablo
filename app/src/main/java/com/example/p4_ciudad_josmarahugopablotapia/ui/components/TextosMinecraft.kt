package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont

@Composable
fun textoMinecraftTitulos(text: String, modifier: Modifier = Modifier, isDarkTheme: Boolean
) {
    Box(modifier = modifier) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier
                .offset(x = 2.dp, y = 2.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = if (isDarkTheme) Color(0xFFEFE27A) else Color.White,  // dorado tipo Minecraft
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun textoMinecraftDescripciones(text: String, modifier: Modifier = Modifier, isDarkTheme: Boolean
) {
    Box(modifier = modifier) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier
                .offset(x = 2.dp, y = 2.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start

        )
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = MinecraftFont,
            color = Color.White,  // dorado tipo Minecraft
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
    }
}
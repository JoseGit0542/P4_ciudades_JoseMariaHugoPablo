package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.amarilloMaincraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano

@Composable
fun botonesInicio(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(grisMinecraftiano)
            .border(3.dp, Color.Black)
            .clickable { onClick() }
            .padding(vertical = 10.dp)
    ) {
        MinecraftButtonText(text = text, modifier = Modifier.align(Alignment.Center))
    }
}
@Composable
fun MinecraftButtonText(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = Modifier
                .offset(x = 1.5.dp, y = 1.5.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = amarilloMaincraftiano,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }

}
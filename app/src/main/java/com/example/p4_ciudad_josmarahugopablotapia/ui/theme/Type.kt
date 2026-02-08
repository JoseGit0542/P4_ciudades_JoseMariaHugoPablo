package com.example.p4_ciudad_josmarahugopablotapia.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.p4_ciudad_josmarahugopablotapia.R
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont

val MinecraftFont: FontFamily = FontFamily(
    Font(R.font.minecraft_font) // sin '+' ni mayúsculas
)

val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MinecraftFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = MinecraftFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
)

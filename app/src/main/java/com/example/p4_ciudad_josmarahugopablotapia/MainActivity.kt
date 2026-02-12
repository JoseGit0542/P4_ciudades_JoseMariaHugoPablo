package com.example.p4_ciudad_josmarahugopablotapia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
// IMPORTANTE: Estas importaciones son necesarias para medir la pantalla
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.p4_ciudad_josmarahugopablotapia.ui.navigation.MinecraftApp

class MainActivity : ComponentActivity() {

    // Añadimos esta anotación porque la API de WindowSize aún es "experimental" en Material 3
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            // 1. Calculamos el tamaño de la ventana
            val windowSize = calculateWindowSizeClass(this)

            // 2. Le pasamos el ancho (widthSizeClass) a tu función principal
            // Esto es lo que permite que tu NavHost sepa qué hacer
            MinecraftApp(windowSize = windowSize.widthSizeClass)
        }
    }
}
package com.example.p4_ciudad_josmarahugopablotapia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.p4_ciudad_josmarahugopablotapia.ui.navigation.MinecraftApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MinecraftApp()
        }
    }
}
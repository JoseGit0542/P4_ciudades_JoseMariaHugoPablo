package com.example.p4_ciudad_josmarahugopablotapia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat.enableEdgeToEdge
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme


//de que va el programa
//nuestro programa consiste en varias pantallas que
//navegan y que recuerdan el estado del sistema, la primera
//pantalla es el inicio, la segunda escoger el bioma de minecraft,
//la tercera escoger la categoria (mobs, estructuras, objetos, vegetacion)
//y la cuarta te muestra lo que hayas elegido (Ej: si escoges objetos tu pulsas el que quieres
//y al pulsar te despliega información sobre dicho objeto)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            P4_ciudad_JoséMaríaHugoPabloTapiaTheme {

            }
        }
    }
}
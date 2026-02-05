package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont


@Composable
fun PantallaInicio(
    onComienzaClick: () -> Unit,
    onObjetoClick: () -> Unit
) {


    val imagenLuna = painterResource(R.drawable.lunaimagen)
    val imagenSol = painterResource(R.drawable.sol)
    val fondoNoche = painterResource(R.drawable.fondo_noche)
    val fondoDia = painterResource(R.drawable.fondodia)
    val logoMinecraft = painterResource(R.drawable.logominecraft)
    val imagenBoton1 = painterResource(R.drawable.comienzaboton)

    P4_ciudad_JoséMaríaHugoPabloTapiaTheme { // <-- Abrimos el bloque del tema correctamente
        var isDarkTheme by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = if (isDarkTheme) fondoNoche else fondoDia,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // para que ocupe toda la pantalla y se recorte si hace falta
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {

                    Image(
                        contentDescription = null,
                        painter = imagenLuna,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(40.dp)
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(8.dp),
                                clip = false
                            )
                            .border(
                                width = 1.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .clip(RoundedCornerShape(8.dp))
                    )
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 180.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(10.dp)) // 👈 baja el inicio del contenido

                Image(
                    painter = logoMinecraft,
                    contentDescription = null,
                    modifier = Modifier.height(120.dp).size(340.dp),
                    contentScale = ContentScale.Fit
                )




                MinecraftPanel(
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    MinecraftTextDay(
                        "Descubre criaturas, elementos y recursos del mundo de Minecraft"
                    )
                }




                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(0.9f),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MinecraftButton(
                                text = "Comenzar",
                                modifier = Modifier.weight(1f).padding(end = 8.dp)
                            ) {
                                onComienzaClick()
                            }

                            MinecraftButton(
                                text = "Explorar",
                                modifier = Modifier.weight(1f).padding(start = 8.dp)
                            ) {
                                onObjetoClick()
                            }

                        }



                    }


                }
            }
        }
    }


}




@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    PantallaInicio(
        onComienzaClick = {},
        onObjetoClick = {}
    )
}
@Composable
fun MinecraftPanel(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .background(Color(0xFFA0A0A0))
            .border(3.dp, Color.Black)
            .padding(6.dp)   // antes 12dp → ahora más compacto
    ) {
        content()
    }
}


@Composable
fun MinecraftTextDay(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {

        val baseModifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)

        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = baseModifier
                .offset(x = 1.5.dp, y = 1.5.dp), // sombra ligera
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.White,
            modifier = baseModifier,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}
@Composable
fun MinecraftButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(Color(0xFFA0A0A0)) // gris más claro
            .border(3.dp, Color.Black)
            .clickable { onClick() }
            .padding(vertical = 10.dp, horizontal = 12.dp)
    ) {
        MinecraftButtonText(
            text = text,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun MinecraftButtonText(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {

        val baseModifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)

        // sombra negra
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color.Black,
            modifier = baseModifier
                .offset(x = 1.5.dp, y = 1.5.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        // texto amarillo estilo logros
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = MinecraftFont,
            color = Color(0xFFFFFF55),
            modifier = baseModifier,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}









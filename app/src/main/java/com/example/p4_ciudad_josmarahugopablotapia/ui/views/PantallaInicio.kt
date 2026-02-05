package com.example.p4_ciudad_josmarahugopablotapia

import android.R.attr.fontFamily
import android.R.attr.onClick
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.MinecraftFont
import kotlinx.coroutines.delay


@Composable
fun PantallaInicio(
    onComienzaClick: () -> Unit,
    onObjetoClick: () -> Unit
) {


    val imagenLuna = painterResource(R.drawable.lunaimagen)
    val imagenSol = painterResource(R.drawable.sol)
    val fondoNoche = painterResource(R.drawable.fondo_noche)
    val fondoDia = painterResource(R.drawable.fondodia)
    val minecraftLogo = painterResource(R.drawable.minecraft_logo_2013)
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
                    .padding(32.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(10.dp)) // 👈 baja el inicio del contenido

                Image(
                    painter = minecraftLogo,
                    contentDescription = null,
                    modifier = Modifier.size(350.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Descubre mundos, criaturas y recursos del maravilloso mundo de Minecraft",
                    modifier = Modifier.padding(top = 8.dp),
                )

                Spacer(modifier = Modifier.height(32.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.comienzaboton),
                            contentDescription = "Comenzar la aventura",
                            modifier = Modifier.clickable { onComienzaClick() }.fillMaxWidth(0.8f)
                        )

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

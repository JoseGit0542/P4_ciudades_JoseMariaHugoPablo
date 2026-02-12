import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.p4_ciudad_josmarahugopablotapia.R
import com.example.p4_ciudad_josmarahugopablotapia.data.Detalle
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.textoMinecraftDescripciones
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.textoMinecraftTitulos
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.textoMinecraftTitulosObjetos
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.amarilloMaincraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisMinecraftiano
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.grisOscuroMinecraftiano

@Composable
fun TarjetaObjeto(
    detalle: Detalle,
    isDarkTheme: Boolean
) {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Color.White),
        color = if (isDarkTheme)
            grisOscuroMinecraftiano
        else
            grisMinecraftiano,
        shadowElevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(detalle.imagenResId),
                    contentDescription = stringResource(detalle.nombreResId),
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    textoMinecraftTitulosObjetos(
                        text = stringResource(detalle.nombreResId),
                        isDarkTheme = isDarkTheme,
                        modifier = Modifier.fillMaxWidth()
                    )

                    textoMinecraftDescripciones(
                        text = stringResource(detalle.descripcionResId),
                        isDarkTheme = isDarkTheme,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(detalle.url)
                                )
                                context.startActivity(intent)
                            },
                        color = amarilloMaincraftiano,
                        shape = RoundedCornerShape(4.dp),
                        border = BorderStroke(3.dp, Color.Black),
                        shadowElevation = 6.dp
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            textoMinecraftTitulos (
                                text = stringResource(R.string.boton_wiki),
                                isDarkTheme = false,
                                modifier = Modifier.fillMaxWidth()
                                        .align(Alignment.Center)
                            )
                        }
                    }

                }
            }
        }
    }
}


package com.example.p4_ciudad_josmarahugopablotapia


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme

/**
 * Pantalla genérica para seleccionar biomas, categorías o lugares.
 *
 * @param titulo Texto que indica qué se está seleccionando.
 * @param opciones Lista de opciones a mostrar (biomas, categorías o lugares).
 * @param onSelectionChanged Lambda para notificar al ViewModel qué opción se seleccionó.
 * @param onCancelar Lambda que se ejecuta al pulsar "Cancelar".
 * @param onSiguiente Lambda que se ejecuta al pulsar "Siguiente".
 */
@Composable
fun SeleccionarBiomas(
    titulo: String,
    opciones: List<String>,
    onSelectionChanged: (String) -> Unit = {},
    onCancelar: () -> Unit = {},
    onSiguiente: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // Lista de opciones con RadioButton
        Column {
            Text(titulo, modifier = Modifier.padding(bottom = 16.dp))

            opciones.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = selectedValue == item,
                            onClick = {
                                selectedValue = item
                                onSelectionChanged(item)
                            }
                        )
                        .padding(vertical = 8.dp)
                ) {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(item)
                }
            }

            Divider(
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        // Botones Cancelar y Siguiente
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelar
            ) {
                Text("Cancelar")
            }

            Button(
                modifier = Modifier.weight(1f),
                enabled = selectedValue.isNotEmpty(),
                onClick = onSiguiente
            ) {
                Text("Siguiente")
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun PreviewSeleccionarBiomas() {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        SeleccionarBiomas(
            titulo = "Selecciona un bioma",
            opciones = listOf(
                "Campos de setas",
                "Taiga",
                "Jungla",
                "Sabana",
                "Bosque"
            ),
            onSelectionChanged = {},
            onCancelar = {},
            onSiguiente = {}
            , modifier = Modifier.fillMaxSize())
    }
}

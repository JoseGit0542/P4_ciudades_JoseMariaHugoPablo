package com.example.p4_ciudad_josmarahugopablotapia

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme

@Composable
fun SeleccionarCategoria(
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
fun PreviewSeleccionarCategoria() {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        SeleccionarCategoria(
            titulo = "Selecciona una categoria",
            opciones = listOf(
                "mobs",
                "objetos",
                "estructuras",
                "vegetacion"
            ),
            onSelectionChanged = {},
            onCancelar = {},
            onSiguiente = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
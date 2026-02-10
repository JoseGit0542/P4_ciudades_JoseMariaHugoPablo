package com.example.p4_ciudad_josmarahugopablotapia.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
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
import androidx.compose.ui.unit.sp
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme

@Composable
fun PantallaOpcion(
    elementoSeleccionado: String = "",
    onNavigateBack: () -> Unit = {},
    onInicioClick: () -> Unit = {},
    onBiomasClick: () -> Unit = {},
    onCategoriasClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp).statusBarsPadding()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Botón para regresar
        Button(
            onClick = onNavigateBack,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("← Atrás")
        }

        Column {
            if (elementoSeleccionado.isNotEmpty()) {
                Text(
                    text = "Has seleccionado: $elementoSeleccionado",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            Text("Selecciona una opción:", modifier = Modifier.padding(bottom = 16.dp))

            val opciones = listOf("Opción 1", "Opción 2", "Opción 3")

            opciones.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = selectedValue == item,
                            onClick = { selectedValue = item }
                        )
                        .padding(vertical = 8.dp)
                ) {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = { selectedValue = item }
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

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            OutlinedButton(modifier = Modifier.weight(1f), onClick = onNavigateBack) {
                Text("Cancelar")
            }

            Button(
                modifier = Modifier.weight(1f),
                enabled = selectedValue.isNotEmpty(),
                onClick = { onNavigateBack() }
            ) {
                Text("Confirmar")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPantallaOpcion() {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        PantallaOpcion(
            elementoSeleccionado = "Campos de setas",
            onNavigateBack = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
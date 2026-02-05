package com.example.p4_ciudad_josmarahugopablotapia.viewModel

import androidx.lifecycle.ViewModel
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource
import com.example.p4_ciudad_josmarahugopablotapia.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    /** Selecciona un bioma y reinicia categoría y elemento */
    fun seleccionarBioma(biomaRes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                lugarSeleccionado = biomaRes,
                categoriaSeleccionada = null,
                elementoSeleccionado = null,
                itemOptions = emptyList()
            )
        }
    }


    /** Selecciona una categoría y actualiza las opciones de elementos según el bioma */
    fun seleccionarCategoria(categoriaRes: Int) {
        val bioma = _uiState.value.lugarSeleccionado ?: return
        val opciones = DataSource.obtenerDetalles(bioma, categoriaRes)

        _uiState.update { currentState ->
            currentState.copy(
                categoriaSeleccionada = categoriaRes,
                elementoSeleccionado = null,
                itemOptions = opciones
            )
        }
    }

    /** Selecciona un elemento concreto dentro de la categoría */
    fun seleccionarElemento(elemento: String) {
        _uiState.update { currentState ->
            currentState.copy(elementoSeleccionado = elemento)
        }
    }

    /** Reinicia toda la selección */
    fun reiniciar() {
        _uiState.value = OrderUiState()
    }

}

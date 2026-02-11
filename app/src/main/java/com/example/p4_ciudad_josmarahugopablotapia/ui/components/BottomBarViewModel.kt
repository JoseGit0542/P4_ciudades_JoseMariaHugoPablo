package com.example.p4_ciudad_josmarahugopablotapia.ui.components

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

data class BottomBarState(
    val inicio: Boolean = true,
    val biomas: Boolean = false,
    val categorias: Boolean = false,
    val opciones: Boolean = false
)

class BottomBarViewModel : ViewModel() {

    private val _state = mutableStateOf(BottomBarState())
    val state: State<BottomBarState> = _state

    fun soloInicio() {
        _state.value = BottomBarState(
            inicio = true
        )
    }

    fun desbloquearBiomas() {
        _state.value = BottomBarState(
            inicio = true,
            biomas = true
        )
    }

    fun desbloquearCategorias() {
        _state.value = BottomBarState(
            inicio = true,
            biomas = true,
            categorias = true
        )
    }

    fun desbloquearOpciones() {
        _state.value = BottomBarState(
            inicio = true,
            biomas = true,
            categorias = true,
            opciones = true
        )
    }

    fun inicioYOpcion() {
        _state.value = BottomBarState(
            inicio = true,
            opciones = true
        )
    }
}

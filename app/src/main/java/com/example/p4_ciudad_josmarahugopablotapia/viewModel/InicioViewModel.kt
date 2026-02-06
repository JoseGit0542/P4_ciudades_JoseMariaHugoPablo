package com.example.p4_ciudad_josmarahugopablotapia.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Estado que representa lo que la UI necesita mostrar
data class InicioUiState(
    val isDarkTheme: Boolean = false
)

class InicioViewModel : ViewModel() {

    // Redactamos el estado de forma privada para que solo el ViewModel lo modifique
    private val _uiState = MutableStateFlow(InicioUiState())
    // Exponemos el estado de forma pública pero solo de lectura
    val uiState = _uiState.asStateFlow()

    // Evento para cambiar el tema
    fun toggleTheme() {
        _uiState.update { it.copy(isDarkTheme = !it.isDarkTheme) }
    }
}
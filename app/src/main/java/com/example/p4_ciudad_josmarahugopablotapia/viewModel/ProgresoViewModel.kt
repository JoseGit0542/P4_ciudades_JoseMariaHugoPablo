package com.example.p4_ciudad_josmarahugopablotapia.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProgresoViewModel : ViewModel() {

    private val _progreso = MutableStateFlow(Progreso.INICIO)
    val progreso = _progreso.asStateFlow()

    fun avanzarA(nuevo: Progreso) {
        _progreso.value = nuevo
    }
}

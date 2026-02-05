package com.example.p4_ciudad_josmarahugopablotapia.data


data class OrderUiState(

    /** Bioma seleccionado */
    val lugarSeleccionado: Int? = null,

    /** Categoría seleccionada */
    val categoriaSeleccionada: Int? = null,

    /** Elemento seleccionado dentro de la categoría */
    val elementoSeleccionado: String? = null,

    /** Lista de elementos disponibles según bioma y categoría */
    val itemOptions: List<String> = emptyList()
)


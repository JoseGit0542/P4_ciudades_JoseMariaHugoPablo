package com.example.p4_ciudad_josmarahugopablotapia

import androidx.annotation.StringRes

enum class PantallaBiomas(@StringRes val title: Int) {
    Inicio(R.string.welcome),
    Bioma(R.string.elegirBioma),
    Categoria(R.string.elegirCategoria),
    Opcion(R.string.elegirOpcion)
}

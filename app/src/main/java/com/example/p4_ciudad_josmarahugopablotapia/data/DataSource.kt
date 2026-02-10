package com.example.p4_ciudad_josmarahugopablotapia.data

import com.example.p4_ciudad_josmarahugopablotapia.R

// Clase que describe cada categoría
data class Categoria(
    val nombreResId: Int,
    val imagenResId: Int,
    val descripcion: String
)

// Nueva clase para Biomas
data class Bioma(
    val nombre: String,
    val imagenResId: Int,
    val descripcion: String
)


object DataSource {

    // Biomas con nombre, imagen y descripción
    val biomas = listOf(
        Bioma("Campos de setas", R.drawable.mushrooms, "Un bioma lleno de setas gigantes."),
        Bioma("Taiga", R.drawable.taiga, "Bosques fríos con abetos."),
        Bioma("Jungla", R.drawable.jungla, "Vegetación densa y húmeda."),
        Bioma("Sabana", R.drawable.sabana, "Llanuras con hierba amarilla.")
    )

    // Categorías con imagen y descripción
    val categorias = listOf(
        Categoria(
            nombreResId = R.string.estructuras,
            imagenResId = R.drawable._35px_21w07a_mineshaft,
            descripcion = "Construcciones generadas automáticamente"
        ),
        Categoria(
            nombreResId = R.string.criaturas,
            imagenResId = R.drawable.mobs,
            descripcion = "Criaturas hostiles y no hostiles"
        ),
        Categoria(
            nombreResId = R.string.recursos,
            imagenResId = R.drawable.items,
            descripcion = "Elementos del inventario del jugador"
        ),
        Categoria(
            nombreResId = R.string.vegetacion,
            imagenResId = R.drawable.vegetacion,
            descripcion = "Vegetación generada según el bioma"
        )
    )

    // Ejemplo: detalles por bioma y categoría
    fun obtenerDetalles(bioma: Int, categoria: Int): List<String> {
        return when (bioma to categoria) {

            // Campos de setas
            R.string.campos_setas to R.string.criaturas -> listOf("Champiñaca")
            R.string.campos_setas to R.string.estructuras -> listOf("Cueva de setas")
            R.string.campos_setas to R.string.recursos -> listOf("Hongos rojos", "Hongos marrones")
            R.string.campos_setas to R.string.vegetacion -> listOf("Setas gigantes", "Micelio")

            // Taiga
            R.string.taiga to R.string.criaturas -> listOf("Lobo", "Zorro, Vaca, Oveja")
            R.string.taiga to R.string.estructuras -> listOf("Aldea Taiga")
            R.string.taiga to R.string.recursos -> listOf("Madera de abeto", "Hielo")
            R.string.taiga to R.string.vegetacion -> listOf("Abetos", "Hierba alta")

            // Jungla
            R.string.jungla to R.string.criaturas -> listOf("Ocelote", "Panda", "Loros")
            R.string.jungla to R.string.estructuras -> listOf("Templo de Jungla")
            R.string.jungla to R.string.recursos -> listOf("Madera de jungla", "Bambú")
            R.string.jungla to R.string.vegetacion -> listOf("Lianas", "Flores tropicales")

            // Sabana
            R.string.sabana to R.string.criaturas -> listOf("Caballo", "Llama", "Burros")
            R.string.sabana to R.string.estructuras -> listOf("Aldea Sabana")
            R.string.sabana to R.string.recursos -> listOf("Madera de acacia", "Hierba")
            R.string.sabana to R.string.vegetacion -> listOf("Acacias", "Hierba alta")

            else -> listOf("Elemento de ejemplo")
        }
    }
}

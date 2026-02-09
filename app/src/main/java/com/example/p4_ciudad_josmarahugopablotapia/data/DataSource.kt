package com.example.p4_ciudad_josmarahugopablotapia.data
import com.example.p4_ciudad_josmarahugopablotapia.R

object DataSource {
    val descripcion = R.string.descripcion
    val biomas = listOf(
        R.string.campos_setas,
        R.string.taiga,
        R.string.jungla,
        R.string.sabana
    )

    val categorias = listOf(
        R.string.estructuras,
        R.string.criaturas,
        R.string.recursos,
        R.string.vegetacion
    )

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


package com.example.p4_ciudad_josmarahugopablotapia.data

import com.example.p4_ciudad_josmarahugopablotapia.R
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource.BIOMA_JUNGLA
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource.BIOMA_SABANA
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource.BIOMA_SETAS
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource.BIOMA_TAIGA
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource.CAT_CRIATURAS
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource.CAT_ESTRUCTURAS
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource.CAT_RECURSOS
import com.example.p4_ciudad_josmarahugopablotapia.data.DataSource.CAT_VEGETACION

// Clase que describe cada categoría
data class Categoria(
    val id: Int,
    val nombreResId: Int,
    val imagenResId: Int,
    val descripcion: String
)

data class Bioma(
    val id: Int,
    val nombreResId: Int,
    val imagenResId: Int,
    val descripcion: String
)

data class Detalle(
    val id: Int,
    val nombre: String,
    val imagenResId: Int,
    val descripcion: String,
    val biomaId: Int,
    val categoriaId: Int
)

private val detalles = listOf(
    // Campos de setas
    Detalle(1, "Champiñaca", R.drawable.champinaca, "Criatura del bioma", BIOMA_SETAS, CAT_CRIATURAS),
    Detalle(2, "Cueva de setas", R.drawable.cueva_setas, "Estructura generada", BIOMA_SETAS, CAT_ESTRUCTURAS),
    Detalle(3, "Hongos rojos", R.drawable.hongos_rojos, "Recurso comestible", BIOMA_SETAS, CAT_RECURSOS),
    Detalle(4, "Setas gigantes", R.drawable.setas_gigantes, "Vegetación típica", BIOMA_SETAS, CAT_VEGETACION),

    // Taiga
    Detalle(5, "Lobo", R.drawable.lobo, "Criatura hostil", BIOMA_TAIGA, CAT_CRIATURAS),
    Detalle(6, "Aldea Taiga", R.drawable.aldea_taiga, "Estructura generada", BIOMA_TAIGA, CAT_ESTRUCTURAS),
    Detalle(7, "Madera de abeto", R.drawable.madera_abeto, "Recurso de madera", BIOMA_TAIGA, CAT_RECURSOS),
    Detalle(8, "Abetos", R.drawable.abetos, "Vegetación típica", BIOMA_TAIGA, CAT_VEGETACION),

    // Jungla
    Detalle(9, "Ocelote", R.drawable.ocelote, "Criatura salvaje", BIOMA_JUNGLA, CAT_CRIATURAS),
    Detalle(10, "Templo de Jungla", R.drawable.templo_jungla, "Estructura generada", BIOMA_JUNGLA, CAT_ESTRUCTURAS),
    Detalle(11, "Bambú", R.drawable.bambu, "Recurso vegetal", BIOMA_JUNGLA, CAT_RECURSOS),
    Detalle(12, "Lianas", R.drawable.lianas, "Vegetación típica", BIOMA_JUNGLA, CAT_VEGETACION),

    // Sabana
    Detalle(13, "Caballo", R.drawable.caballo, "Criatura domesticable", BIOMA_SABANA, CAT_CRIATURAS),
    Detalle(14, "Aldea Sabana", R.drawable.aldea_sabana, "Estructura generada", BIOMA_SABANA, CAT_ESTRUCTURAS),
    Detalle(15, "Madera de acacia", R.drawable.madera_acacia, "Recurso de madera", BIOMA_SABANA, CAT_RECURSOS),
    Detalle(16, "Acacias", R.drawable.acacias, "Vegetación típica", BIOMA_SABANA, CAT_VEGETACION)
)



object DataSource {

    const val BIOMA_SETAS = 1
    const val BIOMA_TAIGA = 2
    const val BIOMA_JUNGLA = 3
    const val BIOMA_SABANA = 4

    // IDs de Categorias
    const val CAT_ESTRUCTURAS = 1
    const val CAT_CRIATURAS = 2
    const val CAT_RECURSOS = 3
    const val CAT_VEGETACION = 4
    // Biomas con nombre, imagen y descripción
    val biomas = listOf(
        Bioma(
            id = BIOMA_SETAS,
            nombreResId = R.string.campos_setas,
            imagenResId = R.drawable.mushrooms,
            descripcion = "Un bioma lleno de setas gigantes."
        ),
        Bioma(
            id = BIOMA_TAIGA,
            nombreResId = R.string.taiga,
            imagenResId = R.drawable.taiga,
            descripcion = "Bosques frios con abetos."
        ),
        Bioma(
            id = BIOMA_JUNGLA,
            nombreResId = R.string.jungla,
            imagenResId = R.drawable.jungla,
            descripcion = "Vegetacion densa y humeda."
        ),
        Bioma(
            id = BIOMA_SABANA,
            nombreResId = R.string.sabana,
            imagenResId = R.drawable.sabana,
            descripcion = "Llanuras con hierba amarilla."
        )
    )


    // Categorías con imagen y descripción
    val categorias = listOf(
        Categoria(
            id = CAT_ESTRUCTURAS,
            nombreResId = R.string.estructuras,
            imagenResId = R.drawable._35px_21w07a_mineshaft,
            descripcion = "Construcciones generadas automaticamente"
        ),
        Categoria(
            id = CAT_CRIATURAS,
            nombreResId = R.string.criaturas,
            imagenResId = R.drawable.mobs,
            descripcion = "Criaturas hostiles y no hostiles"
        ),
        Categoria(
            id = CAT_RECURSOS,
            nombreResId = R.string.recursos,
            imagenResId = R.drawable.items,
            descripcion = "Elementos del inventario del jugador"
        ),
        Categoria(
            id = CAT_VEGETACION,
            nombreResId = R.string.vegetacion,
            imagenResId = R.drawable.vegetacion,
            descripcion = "Vegetacion generada segun el bioma"
        )
    )


    // Ejemplo: detalles por bioma y categoría
    fun obtenerDetalles(biomaId: Int, categoriaId: Int): List<Detalle> {
        return detalles.filter {
            it.biomaId == biomaId && it.categoriaId == categoriaId
        }
    }

}


package com.example.p4_ciudad_josmarahugopablotapia.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.p4_ciudad_josmarahugopablotapia.R

// =====================
// DATA CLASSES
// =====================

data class Categoria(
    val id: Int,
    @StringRes val nombreResId: Int,
    @DrawableRes val imagenResId: Int,
    @StringRes val descripcionResId: Int
)

data class Bioma(
    val id: Int,
    @StringRes val nombreResId: Int,
    @DrawableRes val imagenResId: Int,
    @StringRes val descripcionResId: Int
)

data class Detalle(
    val id: Int,
    val nombre: String,
    @DrawableRes val imagenResId: Int,
    val descripcion: String,
    val biomaId: Int,
    val categoriaId: Int
)

// =====================
// DATOS PRIVADOS
// =====================

private val detalles = listOf(

    // Campos de setas
    Detalle(1, "Champiñaca", R.drawable.champinaca, "Criatura del bioma", DataSource.BIOMA_SETAS, DataSource.CAT_CRIATURAS),
    Detalle(2, "Cueva de setas", R.drawable.cueva_setas, "Estructura generada", DataSource.BIOMA_SETAS, DataSource.CAT_ESTRUCTURAS),
    Detalle(3, "Hongos rojos", R.drawable.hongos_rojos, "Recurso comestible", DataSource.BIOMA_SETAS, DataSource.CAT_RECURSOS),
    Detalle(4, "Setas gigantes", R.drawable.setas_gigantes, "Vegetación típica", DataSource.BIOMA_SETAS, DataSource.CAT_VEGETACION),

    // Taiga
    Detalle(5, "Lobo", R.drawable.lobo, "Criatura hostil", DataSource.BIOMA_TAIGA, DataSource.CAT_CRIATURAS),
    Detalle(6, "Aldea Taiga", R.drawable.aldea_taiga, "Estructura generada", DataSource.BIOMA_TAIGA, DataSource.CAT_ESTRUCTURAS),
    Detalle(7, "Madera de abeto", R.drawable.madera_abeto, "Recurso de madera", DataSource.BIOMA_TAIGA, DataSource.CAT_RECURSOS),
    Detalle(8, "Abetos", R.drawable.abetos, "Vegetación típica", DataSource.BIOMA_TAIGA, DataSource.CAT_VEGETACION),

    // Jungla
    Detalle(9, "Ocelote", R.drawable.ocelote, "Criatura salvaje", DataSource.BIOMA_JUNGLA, DataSource.CAT_CRIATURAS),
    Detalle(10, "Templo de Jungla", R.drawable.templo_jungla, "Estructura generada", DataSource.BIOMA_JUNGLA, DataSource.CAT_ESTRUCTURAS),
    Detalle(11, "Bambú", R.drawable.bambu, "Recurso vegetal", DataSource.BIOMA_JUNGLA, DataSource.CAT_RECURSOS),
    Detalle(12, "Lianas", R.drawable.lianas, "Vegetación típica", DataSource.BIOMA_JUNGLA, DataSource.CAT_VEGETACION),

    // Sabana
    Detalle(13, "Caballo", R.drawable.caballo, "Criatura domesticable", DataSource.BIOMA_SABANA, DataSource.CAT_CRIATURAS),
    Detalle(14, "Aldea Sabana", R.drawable.aldea_sabana, "Estructura generada", DataSource.BIOMA_SABANA, DataSource.CAT_ESTRUCTURAS),
    Detalle(15, "Madera de acacia", R.drawable.madera_acacia, "Recurso de madera", DataSource.BIOMA_SABANA, DataSource.CAT_RECURSOS),
    Detalle(16, "Acacias", R.drawable.acacias, "Vegetación típica", DataSource.BIOMA_SABANA, DataSource.CAT_VEGETACION)
)

// =====================
// DATA SOURCE
// =====================

object DataSource {

    // IDs de Biomas
    const val BIOMA_SETAS = 1
    const val BIOMA_TAIGA = 2
    const val BIOMA_JUNGLA = 3
    const val BIOMA_SABANA = 4

    // IDs de Categorías
    const val CAT_ESTRUCTURAS = 1
    const val CAT_CRIATURAS = 2
    const val CAT_RECURSOS = 3
    const val CAT_VEGETACION = 4

    // Lista de Biomas
    val biomas = listOf(
        Bioma(
            id = BIOMA_SETAS,
            nombreResId = R.string.campos_setas,
            imagenResId = R.drawable.mushrooms,
            descripcionResId = R.string.descripcion_setas
        ),
        Bioma(
            id = BIOMA_TAIGA,
            nombreResId = R.string.taiga,
            imagenResId = R.drawable.taiga,
            descripcionResId = R.string.descripcion_taiga
        ),
        Bioma(
            id = BIOMA_JUNGLA,
            nombreResId = R.string.jungla,
            imagenResId = R.drawable.jungla,
            descripcionResId = R.string.descripcion_jungla
        ),
        Bioma(
            id = BIOMA_SABANA,
            nombreResId = R.string.sabana,
            imagenResId = R.drawable.sabana,
            descripcionResId = R.string.descripcion_sabana
        )
    )

    // Lista de Categorías
    val categorias = listOf(
        Categoria(
            id = CAT_ESTRUCTURAS,
            nombreResId = R.string.estructuras,
            imagenResId = R.drawable._35px_21w07a_mineshaft,
            descripcionResId = R.string.descripcion_estructuras
        ),
        Categoria(
            id = CAT_CRIATURAS,
            nombreResId = R.string.criaturas,
            imagenResId = R.drawable.mobs,
            descripcionResId = R.string.descripcion_criaturas
        ),
        Categoria(
            id = CAT_RECURSOS,
            nombreResId = R.string.recursos,
            imagenResId = R.drawable.items,
            descripcionResId = R.string.descripcion_recursos
        ),
        Categoria(
            id = CAT_VEGETACION,
            nombreResId = R.string.vegetacion,
            imagenResId = R.drawable.vegetacion,
            descripcionResId = R.string.descripcion_vegetacion
        )
    )

    // Obtener detalles filtrados
    fun obtenerDetalles(biomaId: Int, categoriaId: Int): List<Detalle> {
        return detalles.filter {
            it.biomaId == biomaId && it.categoriaId == categoriaId
        }
    }

    // Obtener todos los detalles
    fun obtenerTodosLosDetalles(): List<Detalle> {
        return detalles
    }
}

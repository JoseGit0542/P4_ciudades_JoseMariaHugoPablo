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

data class Categoria(
    val id: Int,
    val nombreResId: Int,
    val imagenResId: Int,
    val descripcionResId: Int  // Cambiado de String a Int (resource ID)
)

data class Bioma(
    val id: Int,
    val nombreResId: Int,
    val imagenResId: Int,
    val descripcionResId: Int  // Cambiado de String a Int (resource ID)
)

data class Detalle(
    val id: Int,
    val nombreResId: Int,      // Cambiado de String a Int (resource ID)
    val imagenResId: Int,
    val descripcionResId: Int, // Cambiado de String a Int (resource ID)
    val biomaId: Int,
    val categoriaId: Int
)

private val detalles = listOf(
    // Campos de setas
    Detalle(1, R.string.champinaca, R.drawable.champinaca, R.string.desc_champinaca, BIOMA_SETAS, CAT_CRIATURAS),
    Detalle(2, R.string.cueva_setas, R.drawable.cueva_setas, R.string.desc_cueva_setas, BIOMA_SETAS, CAT_ESTRUCTURAS),
    Detalle(3, R.string.hongos_rojos, R.drawable.hongos_rojos, R.string.desc_hongos_rojos, BIOMA_SETAS, CAT_RECURSOS),
    Detalle(4, R.string.setas_gigantes, R.drawable.setas_gigantes, R.string.desc_setas_gigantes, BIOMA_SETAS, CAT_VEGETACION),

    // Taiga
    Detalle(5, R.string.lobo, R.drawable.lobo, R.string.desc_lobo, BIOMA_TAIGA, CAT_CRIATURAS),
    Detalle(6, R.string.aldea_taiga, R.drawable.aldea_taiga, R.string.desc_aldea_taiga, BIOMA_TAIGA, CAT_ESTRUCTURAS),
    Detalle(7, R.string.madera_abeto, R.drawable.madera_abeto, R.string.desc_madera_abeto, BIOMA_TAIGA, CAT_RECURSOS),
    Detalle(8, R.string.abetos, R.drawable.abetos, R.string.desc_abetos, BIOMA_TAIGA, CAT_VEGETACION),

    // Jungla
    Detalle(9, R.string.ocelote, R.drawable.ocelote, R.string.desc_ocelote, BIOMA_JUNGLA, CAT_CRIATURAS),
    Detalle(10, R.string.templo_jungla, R.drawable.templo_jungla, R.string.desc_templo_jungla, BIOMA_JUNGLA, CAT_ESTRUCTURAS),
    Detalle(11, R.string.bambu, R.drawable.bambu, R.string.desc_bambu, BIOMA_JUNGLA, CAT_RECURSOS),
    Detalle(12, R.string.lianas, R.drawable.lianas, R.string.desc_lianas, BIOMA_JUNGLA, CAT_VEGETACION),

    // Sabana
    Detalle(13, R.string.caballo, R.drawable.caballo, R.string.desc_caballo, BIOMA_SABANA, CAT_CRIATURAS),
    Detalle(14, R.string.aldea_sabana, R.drawable.aldea_sabana, R.string.desc_aldea_sabana, BIOMA_SABANA, CAT_ESTRUCTURAS),
    Detalle(15, R.string.madera_acacia, R.drawable.madera_acacia, R.string.desc_madera_acacia, BIOMA_SABANA, CAT_RECURSOS),
    Detalle(16, R.string.acacias, R.drawable.acacias, R.string.desc_acacias, BIOMA_SABANA, CAT_VEGETACION)
)

object DataSource {

    const val BIOMA_SETAS = 1
    const val BIOMA_TAIGA = 2
    const val BIOMA_JUNGLA = 3
    const val BIOMA_SABANA = 4

    const val CAT_ESTRUCTURAS = 1
    const val CAT_CRIATURAS = 2
    const val CAT_RECURSOS = 3
    const val CAT_VEGETACION = 4

    val biomas = listOf(
        Bioma(
            id = BIOMA_SETAS,
            nombreResId = R.string.campos_setas,
            imagenResId = R.drawable.mushrooms,
            descripcionResId = R.string.descripcion_campos_setas
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

    fun obtenerDetalles(biomaId: Int, categoriaId: Int): List<Detalle> {
        return detalles.filter {
            it.biomaId == biomaId && it.categoriaId == categoriaId
        }
    }

    fun obtenerTodosLosDetalles(): List<Detalle> {
        return detalles
    }
}
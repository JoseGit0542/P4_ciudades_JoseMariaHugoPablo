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
    val categoriaId: Int,
    val url: String
)

private val detalles = listOf(
    // Campos de setas
    Detalle(1, R.string.champinaca, R.drawable.champinaca, R.string.desc_champinaca, BIOMA_SETAS, CAT_CRIATURAS,"https://minecraft.wiki/w/Mooshroom"),
    Detalle(2, R.string.cueva_setas, R.drawable.cueva_setas, R.string.desc_cueva_setas, BIOMA_SETAS, CAT_ESTRUCTURAS,"https://minecraft.fandom.com/wiki/Mushroom_Fields"),
    Detalle(3, R.string.hongos_rojos, R.drawable.hongos_rojos, R.string.desc_hongos_rojos, BIOMA_SETAS, CAT_RECURSOS,"https://minecraft.fandom.com/es/wiki/Champi%C3%B1%C3%B3n"),
    Detalle(4, R.string.setas_gigantes, R.drawable.setas_gigantes, R.string.desc_setas_gigantes, BIOMA_SETAS, CAT_VEGETACION, "https://es.minecraft.wiki/w/Champi%C3%B1%C3%B3n_enorme"),
    Detalle(17, R.string.vaca_seta_marron, R.drawable.vaca_seta_marron, R.string.desc_vaca_marron, BIOMA_SETAS, CAT_CRIATURAS, "https://es.minecraft.wiki/w/Champi%C3%B1aca"),
    Detalle(18, R.string.micelio, R.drawable.micelio, R.string.desc_micelio, BIOMA_SETAS, CAT_VEGETACION, "https://minecraft.wiki/w/Mycelium"),
    Detalle(28, R.string.sopa_setas, R.drawable.sopa_setas, R.string.desc_sopa_setas, BIOMA_SETAS, CAT_RECURSOS, "https://minecraft.wiki/w/Mushroom_Stew"),

    // --- TAIGA ---
    Detalle(5, R.string.lobo, R.drawable.lobo, R.string.desc_lobo, BIOMA_TAIGA, CAT_CRIATURAS, "https://minecraft.wiki/w/Wolf"),
    Detalle(6, R.string.aldea_taiga, R.drawable.aldea_taiga, R.string.desc_aldea_taiga, BIOMA_TAIGA, CAT_ESTRUCTURAS, "https://minecraft.wiki/w/Village"),
    Detalle(7, R.string.madera_abeto, R.drawable.madera_abeto, R.string.desc_madera_abeto, BIOMA_TAIGA, CAT_RECURSOS, "https://minecraft.wiki/w/Spruce_Log"),
    Detalle(8, R.string.abetos, R.drawable.abetos, R.string.desc_abetos, BIOMA_TAIGA, CAT_VEGETACION, "https://minecraft.wiki/w/Spruce"),
    Detalle(19, R.string.zorro, R.drawable.zorro, R.string.desc_zorro, BIOMA_TAIGA, CAT_CRIATURAS, "https://minecraft.wiki/w/Fox"),
    Detalle(20, R.string.bayas_dulces, R.drawable.bayas_dulces, R.string.desc_bayas_dulces, BIOMA_TAIGA, CAT_VEGETACION, "https://minecraft.wiki/w/Sweet_Berries"),
    Detalle(36, R.string.mansion_pillagers, R.drawable.mansion_pillagers, R.string.desc_mansion_pillagers, BIOMA_TAIGA, CAT_ESTRUCTURAS, "https://minecraft.wiki/w/Woodland_Mansion"),
    Detalle(21, R.string.puesto_saqueadores, R.drawable.puesto_saqueadores, R.string.desc_puesto_saqueadores, BIOMA_TAIGA, CAT_ESTRUCTURAS, "https://minecraft.wiki/w/Pillager_Outpost"),
    Detalle(29, R.string.iglu, R.drawable.iglu, R.string.desc_iglu, BIOMA_TAIGA, CAT_ESTRUCTURAS, "https://minecraft.wiki/w/Igloo"),
    Detalle(30, R.string.helecho, R.drawable.helecho, R.string.desc_helecho, BIOMA_TAIGA, CAT_VEGETACION, "https://minecraft.wiki/w/Fern"),

    // --- JUNGLA ---
    Detalle(9, R.string.ocelote, R.drawable.ocelote, R.string.desc_ocelote, BIOMA_JUNGLA, CAT_CRIATURAS, "https://minecraft.wiki/w/Ocelot"),
    Detalle(10, R.string.templo_jungla, R.drawable.templo_jungla, R.string.desc_templo_jungla, BIOMA_JUNGLA, CAT_ESTRUCTURAS, "https://minecraft.wiki/w/Jungle_Temple"),
    Detalle(11, R.string.bambu, R.drawable.bambu, R.string.desc_bambu, BIOMA_JUNGLA, CAT_RECURSOS, "https://minecraft.wiki/w/Bamboo"),
    Detalle(12, R.string.lianas, R.drawable.lianas, R.string.desc_lianas, BIOMA_JUNGLA, CAT_VEGETACION, "https://minecraft.wiki/w/Vines"),
    Detalle(22, R.string.loro, R.drawable.loro, R.string.desc_loro, BIOMA_JUNGLA, CAT_CRIATURAS, "https://minecraft.wiki/w/Parrot"),
    Detalle(23, R.string.panda, R.drawable.panda, R.string.desc_panda, BIOMA_JUNGLA, CAT_CRIATURAS, "https://minecraft.wiki/w/Panda"),
    Detalle(24, R.string.cacao, R.drawable.cacao, R.string.desc_cacao, BIOMA_JUNGLA, CAT_RECURSOS, "https://minecraft.wiki/w/Cocoa_Beans"),
    Detalle(35, R.string.madera_jungla, R.drawable.madera_jungla, R.string.desc_madera_jungla, BIOMA_JUNGLA, CAT_RECURSOS, "https://minecraft.wiki/w/Jungle_Log"),
    Detalle(31, R.string.sandia, R.drawable.sandia, R.string.desc_sandia, BIOMA_JUNGLA, CAT_VEGETACION, "https://minecraft.wiki/w/Melon"),

    // --- SABANA ---
    Detalle(13, R.string.caballo, R.drawable.caballo, R.string.desc_caballo, BIOMA_SABANA, CAT_CRIATURAS, "https://minecraft.wiki/w/Horse"),
    Detalle(14, R.string.aldea_sabana, R.drawable.aldea_sabana, R.string.desc_aldea_sabana, BIOMA_SABANA, CAT_ESTRUCTURAS, "https://minecraft.wiki/w/Village"),
    Detalle(15, R.string.madera_acacia, R.drawable.madera_acacia, R.string.desc_madera_acacia, BIOMA_SABANA, CAT_RECURSOS, "https://minecraft.wiki/w/Acacia_Log"),
    Detalle(16, R.string.acacias, R.drawable.acacias, R.string.desc_acacias, BIOMA_SABANA, CAT_VEGETACION, "https://minecraft.wiki/w/Acacia"),
    Detalle(25, R.string.llama, R.drawable.llama, R.string.desc_llama, BIOMA_SABANA, CAT_CRIATURAS, "https://minecraft.wiki/w/Llama"),
    Detalle(26, R.string.armadillo, R.drawable.armadillo, R.string.desc_armadillo, BIOMA_SABANA, CAT_CRIATURAS, "https://minecraft.wiki/w/Armadillo"),
    Detalle(27, R.string.pasto_seco, R.drawable.pasto, R.string.desc_pasto_seco, BIOMA_SABANA, CAT_VEGETACION, "https://minecraft.wiki/w/Grass_Block")
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
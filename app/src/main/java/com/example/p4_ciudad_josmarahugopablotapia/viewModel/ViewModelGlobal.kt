package com.example.p4_ciudad_josmarahugopablotapia.viewModel

import android.content.Context
import android.content.res.Configuration
import android.os.LocaleList
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Locale

// Datos de un idioma disponible
data class LocaleInfo(
    val codigo: String,        // "es", "en", "fr", etc.
    val nombreNativo: String   // "Español", "English", "Français"
)

// Estado que representa lo que la UI necesita mostrar
data class InicioUiState(
    val isDarkTheme: Boolean = true,
    val idiomasDisponibles: List<LocaleInfo> = emptyList(),
    val idiomaActual: LocaleInfo = LocaleInfo("es", "Español")
)

class InicioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(InicioUiState())
    val uiState = _uiState.asStateFlow()

    init {
        // Idioma por defecto
        _uiState.update {
            it.copy(
                idiomaActual = LocaleInfo("es", "Español")
            )
        }
    }

    // Evento para cambiar el tema
    fun toggleTheme() {
        _uiState.update { it.copy(isDarkTheme = !it.isDarkTheme) }
    }

    // DETECTA SOLO LOS IDIOMAS QUE REALMENTE EXISTEN EN RES/values-*
    fun cargarIdiomasDisponibles(context: Context) {
        // Solo cargar si no hay idiomas cargados previamente
        if (_uiState.value.idiomasDisponibles.isNotEmpty()) return

        val config = Configuration(context.resources.configuration)
        val idiomasEncontrados = mutableListOf<LocaleInfo>()

        // Solo comprobamos los idiomas que SÉ que tengo creados
        // NO añadimos códigos que no existen
        val codigosAComprobar = listOf("es", "en") // Solo español e inglés por ahora

        for (codigo in codigosAComprobar) {
            try {
                val locale = Locale(codigo)
                config.setLocale(locale)

                // Crear un contexto con este locale para probar si existe
                val testContext = context.createConfigurationContext(config)

                // Intentar obtener un string - si no lanza excepción, el idioma existe
                testContext.resources.getString(com.example.p4_ciudad_josmarahugopablotapia.R.string.app_name)

                // Si llegamos aquí, el idioma existe
                idiomasEncontrados.add(
                    LocaleInfo(
                        codigo = codigo,
                        nombreNativo = locale.getDisplayName(locale).replaceFirstChar { it.uppercase() }
                    )
                )
            } catch (e: Exception) {
                // Este idioma no está disponible, continuamos
            }
        }

        // Ordenar para que el español sea el primero si existe
        idiomasEncontrados.sortBy {
            when (it.codigo) {
                "es" -> 0  // Español primero
                else -> 1  // El resto después
            }
        }

        // Actualizar estado con idiomas disponibles
        _uiState.update {
            it.copy(
                idiomasDisponibles = idiomasEncontrados
            )
        }
    }

    // Obtener idioma actual del sistema
    fun obtenerIdiomaActual(context: Context) {
        val locale = context.resources.configuration.locales[0]
        val codigo = locale.language

        // Buscar si el idioma actual está en nuestra lista
        val idiomaInfo = _uiState.value.idiomasDisponibles.find { it.codigo == codigo }
            ?: LocaleInfo(codigo, locale.getDisplayName(locale).replaceFirstChar { it.uppercase() })

        _uiState.update {
            it.copy(
                idiomaActual = idiomaInfo
            )
        }
    }

    // Cambiar a un idioma específico
    fun cambiarIdioma(context: Context, codigoIdioma: String) {
        val locale = Locale(codigoIdioma)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        config.setLocales(LocaleList(locale))

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        // Buscar el idioma en la lista de disponibles
        val idiomaInfo = _uiState.value.idiomasDisponibles.find { it.codigo == codigoIdioma }
            ?: LocaleInfo(codigoIdioma, locale.getDisplayName(locale).replaceFirstChar { it.uppercase() })

        // Actualizar estado con el nuevo idioma
        _uiState.update {
            it.copy(
                idiomaActual = idiomaInfo
            )
        }
    }

    // Cambiar al siguiente idioma automáticamente (rotación)
    fun cambiarAlSiguienteIdioma(context: Context) {
        val estadoActual = _uiState.value
        var idiomas = estadoActual.idiomasDisponibles

        // Si no hay idiomas, cargarlos
        if (idiomas.isEmpty()) {
            cargarIdiomasDisponibles(context)
            idiomas = _uiState.value.idiomasDisponibles
            if (idiomas.isEmpty()) return
        }

        val idiomaActual = estadoActual.idiomaActual
        val indiceActual = idiomas.indexOfFirst { it.codigo == idiomaActual.codigo }

        // Si no encuentra el índice (por ejemplo, después de recreate), empezar desde 0
        val indiceCalculado = if (indiceActual == -1) 0 else indiceActual
        val indiceSiguiente = (indiceCalculado + 1) % idiomas.size
        val siguienteIdioma = idiomas[indiceSiguiente]

        cambiarIdioma(context, siguienteIdioma.codigo)
    }

    // Método para AÑADIR un nuevo idioma cuando se cree
    fun agregarIdioma(codigo: String, nombreNativo: String) {
        val idiomasActuales = _uiState.value.idiomasDisponibles.toMutableList()

        // Verificar si ya existe
        if (idiomasActuales.none { it.codigo == codigo }) {
            idiomasActuales.add(LocaleInfo(codigo, nombreNativo))

            // Ordenar para que español sea primero
            idiomasActuales.sortBy {
                when (it.codigo) {
                    "es" -> 0
                    else -> 1
                }
            }

            _uiState.update {
                it.copy(
                    idiomasDisponibles = idiomasActuales
                )
            }
        }
    }
}
package com.example.p4_ciudad_josmarahugopablotapia.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.p4_ciudad_josmarahugopablotapia.PantallaBioma
import com.example.p4_ciudad_josmarahugopablotapia.PantallaCategoria
import com.example.p4_ciudad_josmarahugopablotapia.PantallaInicio
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.ui.views.PantallaOpcion
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

// Este enum define las rutas de navegación, IGUAL que en Cupcake
enum class Screen(@StringRes val title: Int) {
    Inicio(com.example.p4_ciudad_josmarahugopablotapia.R.string.welcome),
    Bioma(com.example.p4_ciudad_josmarahugopablotapia.R.string.elegirBioma),
    Categoria(com.example.p4_ciudad_josmarahugopablotapia.R.string.elegirCategoria),
    Opcion(com.example.p4_ciudad_josmarahugopablotapia.R.string.elegirOpcion)
}

@Composable
fun MinecraftApp(
    navController: NavHostController = rememberNavController()
) {
    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Esto es el "router" de la aplicación
            NavHost(
                navController = navController,
                startDestination = Screen.Inicio.name  // Empieza en Inicio
            ) {
                // 1. PANTALLA DE INICIO
                composable(route = Screen.Inicio.name) {
                    val inicioViewModel: InicioViewModel = viewModel()
                    PantallaInicio(
                        onComienzaClick = {
                            // Navega a la pantalla de Biomas
                            navController.navigate(Screen.Bioma.name)
                        },
                        onObjetoClick = {
                            // Navega a la pantalla de Categorías
                            navController.navigate(Screen.Categoria.name)
                        },
                        miViewModel = inicioViewModel
                    )
                }

                // 2. PANTALLA DE BIOMAS
                composable(route = Screen.Bioma.name) {
                    val inicioViewModel: InicioViewModel = viewModel()
                    PantallaBioma(
                        onNavegar = { biomaSeleccionado ->
                            // Cuando el usuario selecciona un bioma
                            // Navega a Opcion y pasa el bioma como parámetro
                            navController.navigate("${Screen.Opcion.name}/$biomaSeleccionado")
                        },
                        miViewModel = inicioViewModel
                    )
                }

                // 3. PANTALLA DE CATEGORÍAS
                composable(route = Screen.Categoria.name) {
                    val inicioViewModel: InicioViewModel = viewModel()
                    PantallaCategoria(
                        onNavegar = { categoriaSeleccionada ->
                            // Cuando el usuario selecciona una categoría
                            // Navega a Opcion y pasa la categoría como parámetro
                            navController.navigate("${Screen.Opcion.name}/$categoriaSeleccionada")
                        },
                        miViewModel = inicioViewModel
                    )
                }

                // 4. PANTALLA DE OPCIONES (con parámetro opcional)
                composable(
                    route = "${Screen.Opcion.name}/{seleccionado}",
                    arguments = listOf(
                        navArgument("seleccionado") {
                            type = NavType.StringType
                            defaultValue = "Nada seleccionado"
                        }
                    )
                ) { backStackEntry ->
                    // Obtiene lo que seleccionó el usuario
                    val seleccionado = backStackEntry.arguments?.getString("seleccionado") ?: ""

                    // Aquí necesitamos modificar PantallaOpcion para que reciba este parámetro
                    // Por ahora solo mostramos Opcion normal
                    PantallaOpcion(
                        elementoSeleccionado = seleccionado,
                        onNavigateBack = { navController.navigateUp() }
                    )
                }
            }
        }
    }
}
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
            NavHost(
                navController = navController,
                startDestination = Screen.Inicio.name
            ) {
                // 1. PANTALLA DE INICIO
                composable(route = Screen.Inicio.name) {
                    val inicioViewModel: InicioViewModel = viewModel()
                    PantallaInicio(
                        onComienzaClick = {
                            navController.navigate(Screen.Bioma.name)
                        },
                        onObjetoClick = {
                            navController.navigate(Screen.Categoria.name)
                        },
                        onOpcionesClick = {
                            navController.navigate("${Screen.Opcion.name}/Nada seleccionado")
                        },
                        miViewModel = inicioViewModel
                    )
                }

                // 2. PANTALLA DE BIOMAS
                composable(route = Screen.Bioma.name) {
                    val inicioViewModel: InicioViewModel = viewModel()
                    PantallaBioma(
                        onNavegar = { bioma ->
                            navController.navigate("${Screen.Opcion.name}/$bioma")
                        },
                        onInicioClick = {
                            navController.popBackStack(Screen.Inicio.name, inclusive = false)
                        },
                        onCategoriasClick = {
                            navController.navigate(Screen.Categoria.name)
                        },
                        onOpcionesClick = {
                            navController.navigate("${Screen.Opcion.name}/Nada seleccionado")
                        },
                        miViewModel = inicioViewModel
                    )
                }

                // 3. PANTALLA DE CATEGORÍAS (¡FALTABA ESTA!)
                composable(route = Screen.Categoria.name) {
                    val inicioViewModel: InicioViewModel = viewModel()
                    PantallaCategoria(
                        onNavegar = { categoria ->
                            navController.navigate("${Screen.Opcion.name}/$categoria")
                        },
                        onInicioClick = {
                            navController.popBackStack(Screen.Inicio.name, inclusive = false)
                        },
                        onBiomasClick = {
                            navController.navigate(Screen.Bioma.name)
                        },
                        onOpcionesClick = {
                            navController.navigate("${Screen.Opcion.name}/Nada seleccionado")
                        },
                        miViewModel = inicioViewModel
                    )
                }

                // 4. PANTALLA DE OPCIONES
                composable(
                    route = "${Screen.Opcion.name}/{seleccionado}",
                    arguments = listOf(
                        navArgument("seleccionado") {
                            type = NavType.StringType
                            defaultValue = "Nada seleccionado"
                        }
                    )
                ) { backStackEntry ->
                    val seleccionado = backStackEntry.arguments?.getString("seleccionado") ?: ""

                    PantallaOpcion(
                        elementoSeleccionado = seleccionado,
                        onNavigateBack = { navController.navigateUp() },
                        onInicioClick = {
                            navController.popBackStack(Screen.Inicio.name, inclusive = false)
                        },
                        onBiomasClick = {
                            navController.navigate(Screen.Bioma.name)
                        },
                        onCategoriasClick = {
                            navController.navigate(Screen.Categoria.name)
                        }
                    )
                }
            }
        }
    }
}
package com.example.p4_ciudad_josmarahugopablotapia.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.BottomBarViewModel
import com.example.p4_ciudad_josmarahugopablotapia.ui.components.MinecraftBottomBar

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
    val inicioViewModel: InicioViewModel = viewModel()
    val bottomBarVM: BottomBarViewModel = viewModel()
    val bottomState = bottomBarVM.state.value

    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {

        // ❗ SIN bottomBar y SIN padding del Scaffold
        Scaffold { _ ->

            NavHost(
                navController = navController,
                startDestination = Screen.Inicio.name,
                modifier = Modifier   // ❗ SIN padding(padding)
            ) {

                composable(Screen.Inicio.name) {
                    bottomBarVM.soloInicio()

                    PantallaInicio(
                        miViewModel = inicioViewModel,
                        bottomState = bottomState,
                        onComienzaClick = {
                            bottomBarVM.desbloquearBiomas()
                            navController.navigate(Screen.Bioma.name)
                        },
                        onObjetoClick = {
                            navController.navigate("${Screen.Opcion.name}/-1/-1")
                        },
                        onOpcionesClick = {
                            bottomBarVM.inicioYOpcion()
                            navController.navigate("${Screen.Opcion.name}/-1/-1")
                        }
                    )
                }

                composable(Screen.Bioma.name) {
                    bottomBarVM.desbloquearBiomas()

                    PantallaBioma(
                        miViewModel = inicioViewModel,
                        bottomState = bottomState,
                        onNavegar = { biomaId ->
                            bottomBarVM.desbloquearCategorias()
                            navController.navigate("${Screen.Categoria.name}/$biomaId")
                        },
                        onInicioClick = {
                            bottomBarVM.soloInicio()
                            navController.navigate(Screen.Inicio.name) {
                                popUpTo(0)
                            }
                        },
                        onCategoriasClick = {
                            bottomBarVM.desbloquearCategorias()
                            navController.navigate("${Screen.Categoria.name}/-1")
                        },
                        onOpcionesClick = {
                            bottomBarVM.desbloquearOpciones()
                            navController.navigate("${Screen.Opcion.name}/-1/-1")
                        }
                    )
                }

                composable(
                    route = "${Screen.Categoria.name}/{biomaId}",
                    arguments = listOf(navArgument("biomaId") { type = NavType.IntType })
                ) { backStackEntry ->

                    bottomBarVM.desbloquearCategorias()

                    val biomaId = backStackEntry.arguments?.getInt("biomaId") ?: -1

                    PantallaCategoria(
                        miViewModel = inicioViewModel,
                        bottomState = bottomState,
                        biomaId = biomaId,
                        onNavegar = { categoriaId ->
                            bottomBarVM.desbloquearOpciones()
                            navController.navigate("${Screen.Opcion.name}/$biomaId/$categoriaId")
                        },
                        onInicioClick = {
                            bottomBarVM.soloInicio()
                            navController.navigate(Screen.Inicio.name) {
                                popUpTo(0)
                            }
                        },
                        onBiomasClick = {
                            bottomBarVM.desbloquearBiomas()
                            navController.popBackStack()
                        },
                        onOpcionesClick = {
                            bottomBarVM.desbloquearOpciones()
                            navController.navigate("${Screen.Opcion.name}/-1/-1")
                        }
                    )
                }

                // 4️⃣ Opción
                composable(
                    route = "${Screen.Opcion.name}/{biomaId}/{categoriaId}",
                    arguments = listOf(
                        navArgument("biomaId") { type = NavType.IntType },
                        navArgument("categoriaId") { type = NavType.IntType }
                    )
                ) { backStackEntry ->

                    val biomaId = backStackEntry.arguments?.getInt("biomaId") ?: -1
                    val categoriaId = backStackEntry.arguments?.getInt("categoriaId") ?: -1

                    if (biomaId == -1 && categoriaId == -1) {
                        // Vienes de EXPLORAR → solo inicio habilitado
                        bottomBarVM.soloInicio()
                    } else {
                        // Vienes del flujo normal → todo desbloqueado
                        bottomBarVM.desbloquearOpciones()
                    }

                    PantallaOpcion(
                        biomaId = biomaId,
                        categoriaId = categoriaId,
                        bottomState = bottomBarVM.state.value,
                        onNavigateBack = { navController.popBackStack() },
                        onInicioClick = {
                            bottomBarVM.soloInicio()
                            navController.navigate(Screen.Inicio.name) {
                                popUpTo(0)
                            }
                        },
                        onBiomasClick = {
                            bottomBarVM.desbloquearBiomas()
                            navController.navigate(Screen.Bioma.name)
                        },
                        onCategoriasClick = {
                            bottomBarVM.desbloquearCategorias()
                            navController.navigate("${Screen.Categoria.name}/-1")
                        }
                    )
                }

            }
        }
    }
}








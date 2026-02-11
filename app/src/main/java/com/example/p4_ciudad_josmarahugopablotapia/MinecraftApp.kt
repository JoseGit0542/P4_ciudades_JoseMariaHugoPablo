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
import com.example.p4_ciudad_josmarahugopablotapia.R
import com.example.p4_ciudad_josmarahugopablotapia.PantallaBioma
import com.example.p4_ciudad_josmarahugopablotapia.PantallaCategoria
import com.example.p4_ciudad_josmarahugopablotapia.PantallaInicio
import com.example.p4_ciudad_josmarahugopablotapia.ui.theme.P4_ciudad_JoséMaríaHugoPabloTapiaTheme
import com.example.p4_ciudad_josmarahugopablotapia.viewModel.InicioViewModel

enum class Screen(@StringRes val title: Int) {
    Inicio(R.string.welcome),
    Bioma(R.string.elegirBioma),
    Categoria(R.string.elegirCategoria),
    Opcion(R.string.elegirOpcion)
}

@Composable
fun MinecraftApp(
    navController: NavHostController = rememberNavController()
) {

    val inicioViewModel: InicioViewModel = viewModel()

    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            NavHost(
                navController = navController,
                startDestination = Screen.Inicio.name
            ) {

                // 1️⃣ Inicio
                composable(Screen.Inicio.name) {
                    PantallaInicio(
                        miViewModel = inicioViewModel,
                        onComienzaClick = { navController.navigate(Screen.Bioma.name) },
                        onObjetoClick = { navController.navigate(Screen.Categoria.name) },
                        onOpcionesClick = {
                            navController.navigate("${Screen.Opcion.name}/${R.string.taiga}/${R.string.criaturas}")
                        }
                    )
                }

                // 2️⃣ Biomas
                composable(Screen.Bioma.name) {
                    PantallaBioma(
                        miViewModel = inicioViewModel,
                        onNavegar = { biomaResId ->
                            // Aquí decides qué categoría usar por defecto
                            navController.navigate(
                                "${Screen.Opcion.name}/$biomaResId/${R.string.criaturas}"
                            )
                        },
                        onInicioClick = {
                            navController.popBackStack(Screen.Inicio.name, false)
                        },
                        onCategoriasClick = {
                            navController.navigate(Screen.Categoria.name)
                        },
                        onOpcionesClick = {
                            navController.navigate(
                                "${Screen.Opcion.name}/${R.string.taiga}/${R.string.criaturas}"
                            )
                        }
                    )
                }

                // 3️⃣ Categorías
                composable(Screen.Categoria.name) {
                    PantallaCategoria(
                        miViewModel = inicioViewModel,
                        onNavegar = { categoriaResId ->
                            // Aquí decides qué bioma usar por defecto
                            navController.navigate(
                                "${Screen.Opcion.name}/${R.string.taiga}/$categoriaResId"
                            )
                        },
                        onInicioClick = {
                            navController.popBackStack(Screen.Inicio.name, false)
                        },
                        onBiomasClick = {
                            navController.navigate(Screen.Bioma.name)
                        },
                        onOpcionesClick = {
                            navController.navigate(
                                "${Screen.Opcion.name}/${R.string.taiga}/${R.string.criaturas}"
                            )
                        }
                    )
                }

                // 4️⃣ Opciones (ACTUALIZADA)
                composable(
                    route = "${Screen.Opcion.name}/{bioma}/{categoria}",
                    arguments = listOf(
                        navArgument("bioma") { type = NavType.IntType },
                        navArgument("categoria") { type = NavType.IntType }
                    )
                ) { backStackEntry ->

                    val biomaResId =
                        backStackEntry.arguments?.getInt("bioma") ?: R.string.taiga

                    val categoriaResId =
                        backStackEntry.arguments?.getInt("categoria") ?: R.string.criaturas

                    PantallaOpcion(
                        biomaResId = biomaResId,
                        categoriaResId = categoriaResId,
                        onNavigateBack = { navController.navigateUp() },
                        onInicioClick = {
                            navController.popBackStack(Screen.Inicio.name, false)
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

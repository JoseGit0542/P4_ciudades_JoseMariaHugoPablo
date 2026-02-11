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

    P4_ciudad_JoséMaríaHugoPabloTapiaTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

            NavHost(
                navController = navController,
                startDestination = Screen.Inicio.name
            ) {

                // 1. Inicio
                composable(Screen.Inicio.name) {
                    PantallaInicio(
                        miViewModel = inicioViewModel,
                        onComienzaClick = { navController.navigate(Screen.Bioma.name) },
                        onObjetoClick = { navController.navigate(Screen.Categoria.name) },
                        onOpcionesClick = {
                            navController.navigate("${Screen.Opcion.name}/-1/-1")
                        }
                    )
                }

                // 2. Bioma
                composable(Screen.Bioma.name) {
                    PantallaBioma(
                        miViewModel = inicioViewModel,
                        onNavegar = { biomaId ->
                            navController.navigate("${Screen.Opcion.name}/$biomaId/-1")
                        },
                        onInicioClick = { navController.popBackStack(Screen.Inicio.name, false) },
                        onCategoriasClick = { navController.navigate(Screen.Categoria.name) },
                        onOpcionesClick = { navController.navigate("${Screen.Opcion.name}/-1/-1") }
                    )
                }

                // 3. Categoría
                composable(Screen.Categoria.name) {
                    PantallaCategoria(
                        miViewModel = inicioViewModel,
                        onNavegar = { categoriaId ->
                            navController.navigate("${Screen.Opcion.name}/-1/$categoriaId")
                        },
                        onInicioClick = { navController.popBackStack(Screen.Inicio.name, false) },
                        onBiomasClick = { navController.navigate(Screen.Bioma.name) },
                        onOpcionesClick = { navController.navigate("${Screen.Opcion.name}/-1/-1") }
                    )
                }

                // 4. Opción (recibe biomaId y categoriaId)
                composable(
                    route = "${Screen.Opcion.name}/{biomaId}/{categoriaId}",
                    arguments = listOf(
                        navArgument("biomaId") { type = NavType.IntType },
                        navArgument("categoriaId") { type = NavType.IntType }
                    )
                ) { backStackEntry ->

                    val biomaId = backStackEntry.arguments?.getInt("biomaId") ?: -1
                    val categoriaId = backStackEntry.arguments?.getInt("categoriaId") ?: -1

                    PantallaOpcion(
                        biomaId = biomaId,
                        categoriaId = categoriaId,
                        onNavigateBack = { navController.navigateUp() },
                        onInicioClick = { navController.popBackStack(Screen.Inicio.name, false) },
                        onBiomasClick = { navController.navigate(Screen.Bioma.name) },
                        onCategoriasClick = { navController.navigate(Screen.Categoria.name) }
                    )
                }
            }
        }
    }
}

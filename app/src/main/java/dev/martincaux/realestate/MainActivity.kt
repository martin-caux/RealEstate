package dev.martincaux.realestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import dev.martincaux.core.navigation.Route
import dev.martincaux.core.theme.RealEstateTheme
import dev.martincaux.property.detail.presentation.compose.DetailScreen
import dev.martincaux.property.detail.presentation.viewmodel.DetailViewModel
import dev.martincaux.property.list.presentation.compose.ListScreen
import dev.martincaux.property.list.presentation.viewmodel.ListViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RealEstateTheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
                navController.handleDeepLink(intent)
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Route.RealEstateList.route) {
        composable(Route.RealEstateList.route) {
            val viewModel = koinViewModel<ListViewModel>()
            ListScreen(modifier = modifier, viewModel = viewModel) { route ->
                navController.navigate(route)
            }
        }
        composable(
            route = Route.RealEstateDetail.route,
            arguments = listOf(androidx.navigation.navArgument("itemId") {
                type = androidx.navigation.NavType.IntType
            }),
            deepLinks = listOf(navDeepLink { uriPattern = "realestate://listings/detail/{itemId}" })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0
            val viewModel: DetailViewModel = koinViewModel<DetailViewModel> { parametersOf(itemId) }
            DetailScreen(modifier = modifier, viewModel = viewModel) {
                navController.navigateUp()
            }
        }
    }
}

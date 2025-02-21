package com.arturomarmolejo.toyotataskscc.data.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arturomarmolejo.toyotataskscc.data.presentation.ui.DetailScreen
import com.arturomarmolejo.toyotataskscc.data.presentation.ui.HomeScreen
import com.arturomarmolejo.toyotataskscc.data.presentation.viewmodel.TasksViewModel

@Composable
fun TaskNavigation(
    tasksViewModel: TasksViewModel
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route
    ) {
        composable(route = Routes.HomeScreen.route) {
            HomeScreen(tasksViewModel, navController)
        }
        composable(route = Routes.DetailScreen.route) {
            DetailScreen(tasksViewModel, navController)
        }
    }
}
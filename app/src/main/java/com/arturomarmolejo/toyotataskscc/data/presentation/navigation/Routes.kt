package com.arturomarmolejo.toyotataskscc.data.presentation.navigation

sealed class Routes(val route: String) {
    data object HomeScreen: Routes("HomeScreen")
    data object DetailScreen: Routes("DetailScreen")
}
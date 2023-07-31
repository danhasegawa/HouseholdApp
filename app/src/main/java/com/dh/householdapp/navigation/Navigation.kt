package com.dh.householdapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(route = Screen.ExpenseScreen.route) {
//            val viewModel: ExpenseViewModel = viewModel()
//            val state by viewModel.state.collectAsState()

            ExpenseScreen()

        }
        composable(route = Screen.IncomeScreen.route) {
            IncomeScreen()
        }

    }
}



package com.dh.householdapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dh.householdapp.domain.view.ExpenseViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(route = Screen.ExpenseScreen.route) {
            val viewModel: ExpenseViewModel = viewModel()
            val state by viewModel.state.collectAsState()
            ExpenseScreen(state = state, onEvent = viewModel::onEvent)
//            Text(text = "Expense Screen")
        }
        composable(route = Screen.IncomeScreen.route) {
            IncomeScreen()
        }

    }
}



package com.dh.householdapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.dh.householdapp.domain.view.ExpenseScreen
import com.dh.householdapp.ui.theme.HouseholdAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ExpenseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HouseholdAppTheme {
                val state by viewModel.state.collectAsState()


                ExpenseScreen(state = state, onEvent = viewModel::onEvent)

            }
        }
    }
}




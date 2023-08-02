package com.dh.householdapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dh.householdapp.navigation.Navigation
import com.dh.householdapp.ui.theme.HouseholdAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HouseholdAppTheme {
                Navigation()
            }
        }
    }
}


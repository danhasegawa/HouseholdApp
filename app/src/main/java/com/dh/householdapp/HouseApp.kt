package com.dh.householdapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HouseApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
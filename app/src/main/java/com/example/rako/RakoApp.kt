package com.example.rako

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RakoApp : Application() {
    companion object {

        lateinit var instance: RakoApp

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
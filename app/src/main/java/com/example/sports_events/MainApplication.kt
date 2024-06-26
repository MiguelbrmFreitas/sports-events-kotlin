package com.example.sports_events

import android.app.Application
import com.example.data.di.DataModule
import com.example.sports_events.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            AppModule.loadModules()
            DataModule.loadModules()
        }
    }

}
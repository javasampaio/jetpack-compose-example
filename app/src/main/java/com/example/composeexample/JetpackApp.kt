package com.example.composeexample

import android.app.Application
import com.example.composeexample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class JetpackApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@JetpackApp)
            modules(appModule)
        }
    }
}
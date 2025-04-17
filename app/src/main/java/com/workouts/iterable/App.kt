package com.workouts.iterable

import android.app.Application
import com.workouts.iterable.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        insertKoin()
    }


    private fun insertKoin()=
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModules)
        }


}
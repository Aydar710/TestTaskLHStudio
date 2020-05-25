package com.lifehack.testtasklhstudio

import android.app.Application
import com.lifehack.data.di.dataModule
import com.lifehack.feature_companies_list.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                dataModule,
                mainModule
            )
        }
    }
}

package com.example.marvel.application

import android.app.Application
import com.example.core_android.network.api.networkModule
import com.example.list.di.ListScreenModule
import org.koin.core.context.GlobalContext.startKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
                modules(listOf(networkModule, ListScreenModule))
        }
    }

}
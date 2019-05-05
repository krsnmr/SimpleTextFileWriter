package com.example.a777.simpletextfilewriter.di

import android.app.Application

internal class MainApplication : Application() {


    lateinit var component: AppComponent

    companion object {
        lateinit var instance:MainApplication private set
    }

    override fun onCreate() {
        super.onCreate()
        //component.inject(this)
        instance = this
        setup()
    }

    fun setup() {
       component = DaggerAppComponent
                .builder()
                .appModule(  AppModule(this))
               .activityModule(ActivityModule())
                .build()
        //component.inject(this)
    }


    fun getAppComponent():AppComponent{
        return component
    }


}

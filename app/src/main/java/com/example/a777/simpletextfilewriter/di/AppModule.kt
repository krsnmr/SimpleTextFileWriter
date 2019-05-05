package com.example.a777.simpletextfilewriter.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app:Application) {

    @Provides
    @Singleton
    fun provideApplication() = app


}
package com.example.a777.simpletextfilewriter.di

import android.app.Application
import com.example.a777.simpletextfilewriter.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Соединение модуля компонента и приложения
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ActivityModule::class))
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
package com.example.a777.simpletextfilewriter.di

import android.app.Activity
import com.example.a777.simpletextfilewriter.TextFile
import com.example.a777.simpletextfilewriter.TextFileImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule {


    @Singleton
    @Provides
    fun providTextFile(): TextFile {
        return TextFileImpl()
    }
}
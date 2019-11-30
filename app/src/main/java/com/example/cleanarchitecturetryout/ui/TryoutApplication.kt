package com.example.cleanarchitecturetryout.ui

import android.content.Context
import com.example.cleanarchitecturetryout.framework.di.application.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TryoutApplication: DaggerApplication() {

    init {
        instance = this
    }

    companion object {
        private var instance: TryoutApplication? = null

        fun applicationContext(): Context = instance!!.applicationContext
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }
}
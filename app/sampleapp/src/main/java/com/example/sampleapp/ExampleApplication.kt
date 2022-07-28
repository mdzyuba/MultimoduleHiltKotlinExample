package com.example.sampleapp

import androidx.multidex.MultiDexApplication
import com.example.modulea.AppInit
import dagger.hilt.android.EntryPointAccessors


open class ExampleApplication: MultiDexApplication() {

    var canInitialize = true

    override fun onCreate() {
        super.onCreate()
        AppInit.init(this)
        if (canInitialize) {
            callFoo()
        }
    }

    fun callFoo() {
        EntryPointAccessors.fromApplication(this, FooEntryPoint::class.java).foo().onCreate()
    }
}
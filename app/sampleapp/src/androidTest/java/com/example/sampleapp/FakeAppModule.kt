package com.example.sampleapp

import android.util.Log
import com.example.sampleapp.hilt.AppModule
import com.example.sampleapp.instrumentation.InstrumentationObserver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

//@Module
//@TestInstallIn(
//    components = [SingletonComponent::class],
//    replaces = [AppModule::class]
//)
//@InstallIn(SingletonComponent::class)
class FakeAppModule {

//    @Provides
//    fun provideInstrumentationObserver(): InstrumentationObserver {
//        return CustomInstrumentationObserver()
//    }
//
//    class CustomInstrumentationObserver(): InstrumentationObserver {
//        override fun observe() {
//            Log.d("Instrumentation", "fake custom observing ...")
//        }
//    }
}
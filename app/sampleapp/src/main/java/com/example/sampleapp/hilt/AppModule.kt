package com.example.sampleapp.hilt

import com.example.sampleapp.instrumentation.InstrumentationObserver
import com.example.sampleapp.instrumentation.InstrumentationObserverNoop
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideInstrumentationObserver(): InstrumentationObserver {
        return InstrumentationObserverNoop()
    }

}
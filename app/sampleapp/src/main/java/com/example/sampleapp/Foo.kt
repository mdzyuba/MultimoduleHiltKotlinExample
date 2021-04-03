package com.example.sampleapp

import com.example.sampleapp.instrumentation.InstrumentationObserver
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class Foo @Inject constructor() {

    @Inject
    lateinit var instrumentationObserver: InstrumentationObserver

    fun onCreate() {
        instrumentationObserver.observe()
    }
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FooEntryPoint {

    fun foo(): Foo
}
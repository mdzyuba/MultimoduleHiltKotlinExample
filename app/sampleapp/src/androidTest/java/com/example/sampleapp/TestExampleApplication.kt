package com.example.sampleapp

open class TestExampleApplication: ExampleApplication() {
    override fun onCreate() {
        canInitialize = false
        super.onCreate()
    }
}
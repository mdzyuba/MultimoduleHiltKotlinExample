package com.example.sampleapp

import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(TestExampleApplication::class)
interface CustomTestApplication {
}
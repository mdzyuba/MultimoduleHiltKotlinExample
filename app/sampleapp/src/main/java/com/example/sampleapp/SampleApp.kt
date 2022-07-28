package com.example.sampleapp

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleApp(): MultiDexApplication() {
}
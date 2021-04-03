package com.example.sampleapp.instrumentation

import android.util.Log

class InstrumentationObserverNoop(): InstrumentationObserver {
    override fun observe() {
        Log.d("Instrumentation", "noop - observing ...")
    }
}
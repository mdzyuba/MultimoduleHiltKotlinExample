package com.example.sampleapp.repository

import android.util.Log

class ToyStore: Store {
    override fun open() {
        Log.d("ToyStore", "open")
    }

    override fun name(): String {
        return "ToyStore"
    }
}
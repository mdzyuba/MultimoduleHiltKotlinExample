package com.example.sampleapp.repository

import android.util.Log

class FakeToyStore: Store {
    override fun open() {
        Log.d("FakeToyStore", "open")
    }

    override fun name(): String {
        return "FakeToyStore"
    }
}
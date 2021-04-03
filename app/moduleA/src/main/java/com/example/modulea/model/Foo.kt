package com.example.modulea.model

import javax.inject.Inject

class Foo @Inject constructor(x: Int) {
    private val f = x
    fun xyz(): Int {
        return f
    }
}

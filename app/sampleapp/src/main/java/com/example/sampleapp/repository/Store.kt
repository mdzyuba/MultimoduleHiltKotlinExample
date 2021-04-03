package com.example.sampleapp.repository

interface Store {
    fun open()

    fun name(): String
}
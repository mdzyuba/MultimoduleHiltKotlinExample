package com.example.order.model

interface Order {
    fun price(): Int
    fun address(): String
    fun priority(): Int
    fun tax(): Int
}
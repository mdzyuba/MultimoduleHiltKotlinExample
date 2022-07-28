package com.example.modulea.model

class FakeOrder: Order {

    override fun price(): Int {
        return 1
    }

    override fun address(): String {
        return "Fake address"
    }

    override fun priority(): Int {
        return 2
    }

    override fun tax(): Int {
        return 3
    }
}
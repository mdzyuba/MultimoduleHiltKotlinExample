package com.example.order.model

class FakeOrder: Order {
    override fun product(): String {
        return "Coffee"
    }

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
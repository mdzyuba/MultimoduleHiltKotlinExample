package com.example.modulea.model

class MailOrder: Order {
    override fun price(): Int {
        return 4
    }

    override fun address(): String {
        return "Mailing address"
    }

    override fun priority(): Int {
        return 0
    }

    override fun tax(): Int {
        return 100000
    }
}
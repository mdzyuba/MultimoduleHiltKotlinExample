package com.example.order.model

import javax.inject.Inject

class OrderImpl @Inject constructor(val addressProvider: AddressProvider): Order {
    override fun price(): Int {
        return 4
    }

    override fun address(): String {
        return addressProvider.getAddress()
    }

    override fun priority(): Int {
        return 0
    }

    override fun tax(): Int {
        return 100000
    }
}
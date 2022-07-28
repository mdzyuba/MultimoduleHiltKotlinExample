package com.example.shipping.address

import com.example.order.model.AddressProvider
import javax.inject.Inject

class AddressProviderImpl @Inject constructor(): AddressProvider {

    companion object {
        val address: String = "123 Some Str, Big City, CA"
    }

    override fun getAddress(): String {
        return address
    }
}
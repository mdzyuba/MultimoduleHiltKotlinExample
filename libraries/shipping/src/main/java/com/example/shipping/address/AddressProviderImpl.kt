package com.example.shipping.address

import com.example.order.model.AddressProvider
import javax.inject.Inject

class AddressProviderImpl @Inject constructor(): AddressProvider {
    override fun getAddress(): String {
        return "123 Some Str, Big City, CA"
    }
}
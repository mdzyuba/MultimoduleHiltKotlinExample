package com.example.product

import com.example.order.model.Product
import javax.inject.Inject

class ProductImpl @Inject constructor() : Product {
    override fun getName(): String {
        return "Wine"
    }
}
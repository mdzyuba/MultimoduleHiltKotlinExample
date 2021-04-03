package com.example.modulec.services

import javax.inject.Inject

class Service001Impl @Inject constructor(): Service001 {
    override fun provide(): String {
        return "Service 001"
    }
}
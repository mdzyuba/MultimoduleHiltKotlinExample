package com.example.modulea

import android.app.Application
import com.example.modulea.model.MailOrder

object AppInit {

    fun init(application: Application) {
        val order = MailOrder()
    }
}
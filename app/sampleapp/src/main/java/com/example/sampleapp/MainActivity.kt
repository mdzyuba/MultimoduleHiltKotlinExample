package com.example.sampleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.order.model.Order
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Injecting an object defined in module A
    @Inject
    lateinit var order: Order

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOrder: Button = findViewById(R.id.button_order)
        buttonOrder.setOnClickListener {
            val intent = Intent("com.example.sampleapp.order.DETAILS")
            // Adding package to resolve an ambiguity between the app and its test.
            intent.`package`= application.packageName
            startActivity(intent)
        }
    }
}
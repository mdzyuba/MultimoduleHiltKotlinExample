package com.example.sampleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

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
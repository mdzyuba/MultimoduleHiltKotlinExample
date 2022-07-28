package com.example.shipping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.order.model.AddressProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShippingActivity : AppCompatActivity() {

    @Inject
    lateinit var addressProvider: AddressProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)

        val addressText = findViewById<TextView>(R.id.textView_address)
        addressText.text = addressProvider.getAddress()
    }
}
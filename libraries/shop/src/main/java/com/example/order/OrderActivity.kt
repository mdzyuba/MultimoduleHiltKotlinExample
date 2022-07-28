package com.example.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.order.model.Order
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OrderActivity : AppCompatActivity() {

    @Inject
    lateinit var order: Order

    lateinit var addressTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        addressTextView  = findViewById(R.id.textView_address_value)

        val buttonSubmit: Button = findViewById(R.id.button_submit)
        buttonSubmit.setOnClickListener {
            // Navigate to Module B - Confirmation
            val intent = Intent(this, OrderConfirmationActivity::class.java)
            startActivity(intent)
            finish()
        }

        Log.d("OrderActivity", "order: ${order.address()}")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.d("OrderActivity", "order: ${order.address()}")
        addressTextView.text = order.address()
    }
}
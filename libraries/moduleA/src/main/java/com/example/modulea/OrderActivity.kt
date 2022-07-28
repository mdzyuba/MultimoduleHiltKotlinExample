package com.example.modulea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.modulea.model.Bar
import com.example.modulea.model.Foo
import com.example.modulea.model.Order
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OrderActivity : AppCompatActivity() {

    @Inject
    lateinit var order: Order

    @Inject
    lateinit var bar: Bar

    @Inject
    lateinit var foo: Foo

    lateinit var addressTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        addressTextView  = findViewById(R.id.textView_address_value)

        val buttonSubmit: Button = findViewById(R.id.button_submit)
        buttonSubmit.setOnClickListener {
            // Navigate to Module B - Confirmation
            val intent = Intent().apply {
                action = "com.example.sampleapp.order.CONFIRMATION"
                // Required to fix "Complete action using .." dialog
                // SampleApp
                // OrderConfirmation
                // only while running tests on the app level.
                // Does not seem to be required on the module level.
                // Note: application.packageName returns com.example.modulea.test while running module tests.
                `package` =  application.packageName
            }
            startActivity(intent)
            finish()
        }

        foo.xyz()
        bar.doIt()
        Log.d("OrderActivity", "order: ${order.address()}")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.d("OrderActivity", "order: ${order.address()}")
        addressTextView.text = order.address()
    }
}
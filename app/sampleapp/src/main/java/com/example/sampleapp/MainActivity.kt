package com.example.sampleapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.modulea.model.Order
import com.example.moduleb.ModuleBMainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Injecting an object defined in module A
    @Inject
    lateinit var order: Order

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            textView.text = getString(R.string.one)
        }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            textView.text = getString(R.string.two)
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            textView.text = getString(R.string.three)
        }

        val buttonModB: Button = findViewById(R.id.button_mod_b)
        buttonModB.setOnClickListener {
            val intent = Intent(this, ModuleBMainActivity::class.java)
            startActivity(intent)
        }

        val buttonOrder: Button = findViewById(R.id.button_order)
        buttonOrder.setOnClickListener {
            val intent = Intent("com.example.sampleapp.order.DETAILS")
            // Adding package to resolve an ambiguity between the app and its test.
            intent.`package`= application.packageName
            startActivity(intent)
        }
        val s = getString(R.string.verify_identity_tip_self_multiple_device, "AAAA", "BBBB")
        Log.d("test", "verify_identity_tip_self_multiple_device: $s")

        val b = getString(R.string.contact_info_security_modal_bsp, "AAAA", "BBBB")
        Log.d("test", "contact_info_security_modal_bsp: $b")
    }
}
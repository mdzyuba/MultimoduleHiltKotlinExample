package com.example.moduleb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.moduleb.service.StoreService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OrderConfirmationActivity : AppCompatActivity() {

    @Inject
    lateinit var store: StoreService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmation)

        val buttonHome: Button = findViewById(R.id.button_home)
        buttonHome.setOnClickListener {
            val intent = packageManager.getLaunchIntentForPackage(application.packageName)
            startActivity(intent)
            finish()
        }

        val buttonEdit: Button = findViewById(R.id.button_edit)
        buttonEdit.setOnClickListener {
            val intent = Intent().apply {
                action = "com.example.sampleapp.order.DETAILS"
                `package` = application.packageName
            }
            startActivity(intent)
            finish()
        }

        val storeAvailableLabel: TextView = findViewById(R.id.textView_available)
        if (store.isAvailable()) {
            storeAvailableLabel.text = getString(R.string.yes)
        } else {
            storeAvailableLabel.text = getString(R.string.no)
        }

    }
}
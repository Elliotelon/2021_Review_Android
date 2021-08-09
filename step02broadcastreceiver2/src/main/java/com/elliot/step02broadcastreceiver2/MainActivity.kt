package com.elliot.step02broadcastreceiver2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val brBtn by lazy {findViewById<Button>(R.id.brBtn)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        brBtn.setOnClickListener {
            val intent = Intent("com.elliot.testbr")
            sendBroadcast(intent)
        }
    }
}
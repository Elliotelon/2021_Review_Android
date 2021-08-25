package com.elliot.step05intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val subTextView = findViewById<TextView>(R.id.subTextView)
        val resultBtn = findViewById<Button>(R.id.resultBtn)

        subTextView.text = intent.getStringExtra("send")

        resultBtn.setOnClickListener {
            val intent = Intent().putExtra("result", "Ok")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
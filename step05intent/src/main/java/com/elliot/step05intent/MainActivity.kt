package com.elliot.step05intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    val mainTextView by lazy { findViewById<TextView>(R.id.mainTextView) }

    val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            mainTextView.text = result.data?.getStringExtra("result")
        }else {
            mainTextView.text = "Fail"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText = findViewById<EditText>(R.id.editText)
        val sendBtn = findViewById<Button>(R.id.sendBtn)

        sendBtn.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("send", editText.text.toString())
            getAction.launch(intent)
        }
    }
}
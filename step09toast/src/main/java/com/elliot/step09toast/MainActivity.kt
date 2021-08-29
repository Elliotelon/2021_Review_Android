package com.elliot.step09toast

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val btn1 by lazy {findViewById<Button>(R.id.btn1)}
    private val btn2 by lazy {findViewById<Button>(R.id.btn2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            var t1 = Toast.makeText(this, "토스트 메시지", Toast.LENGTH_SHORT)
            t1.show()
        }

        btn2.setOnClickListener { view ->
            var v1 = layoutInflater.inflate(R.layout.custom_toast, null)

            v1.setBackgroundResource(android.R.drawable.toast_frame)

            var image: ImageView = v1.findViewById(R.id.iv)
            image.setImageResource(R.mipmap.ic_launcher)

            var text: TextView = v1.findViewById(R.id.tv)
            text.text = "토스트"
            text.setTextColor(Color.BLACK)

            var t2 = Toast(this)
            t2.setGravity(Gravity.CENTER, 0, 400)
            t2.view = v1
            t2.show()

        }
    }
}

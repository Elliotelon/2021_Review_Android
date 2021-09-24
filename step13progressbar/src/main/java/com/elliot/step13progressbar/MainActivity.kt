package com.elliot.step13progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}
    private val button3 by lazy {findViewById<Button>(R.id.button3)}
    private val button4 by lazy {findViewById<Button>(R.id.button4)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    private val progressBar4 by lazy {findViewById<ProgressBar>(R.id.progressBar4)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "현재 값 : ${progressBar4.progress}"
        }

        button2.setOnClickListener {
            progressBar4.progress = 140
        }

        button3.setOnClickListener {
            progressBar4.incrementProgressBy(10)
        }

        button4.setOnClickListener {
            progressBar4.incrementProgressBy(-10)
        }
    }
}
package com.elliot.step16switch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}
    private val button3 by lazy {findViewById<Button>(R.id.button3)}

    private val switch1 by lazy {findViewById<Switch>(R.id.switch1)}
    private val switch2 by lazy {findViewById<Switch>(R.id.switch2)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if(switch1.isChecked) {
                textView.text = "ON 상태 입니다."
            } else {
                textView.text = "OFF 상태 입니다."
            }
        }

        button2.setOnClickListener {
            switch1.isChecked = true
        }

        button3.setOnClickListener {
            switch1.isChecked = false
        }

        switch1.setOnCheckedChangeListener(listener1)

        switch2.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                textView2.text = "두 번째 스위치가 ON 상태가 되었습니다."
            } else {
                textView2.text = "두 번째 스위치가 OFF 상태가 되었습니다."
            }
        }
    }

    private val listener1 =
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            when(buttonView?.id) {
                R.id.switch1 -> {
                    if(isChecked) {
                        textView.text = "첫 번째 스위치가 ON 상태가 되었습니다."
                    } else {
                        textView.text = "첫 번째 스위치가 OFF 상태가 되었습니다."
                    }
                }
            }
        }
}
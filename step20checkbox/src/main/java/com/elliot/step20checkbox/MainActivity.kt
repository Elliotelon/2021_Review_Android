package com.elliot.step20checkbox

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val textView by lazy { findViewById<TextView>(R.id.textView)}
    private val checkBox by lazy { findViewById<CheckBox>(R.id.checkBox)}
    private val checkBox2 by lazy { findViewById<CheckBox>(R.id.checkBox2)}
    private val checkBox3 by lazy { findViewById<CheckBox>(R.id.checkBox3)}
    private val button by lazy { findViewById<Button>(R.id.button)}
    private val button2 by lazy { findViewById<Button>(R.id.button2)}
    private val button3 by lazy { findViewById<Button>(R.id.button3)}
    private val button4 by lazy { findViewById<Button>(R.id.button4)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = ""
            if(checkBox.isChecked) {
                textView.append("첫 번째 체크 박스 체크\n")
            }else {
                textView.append("첫 번째 체크 박스 해제\n")
            }

            if(checkBox2.isChecked) {
                textView.append("두 번째 체크 박스 체크\n")
            }else {
                textView.append("두 번째 체크 박스 해제\n")
            }

            if(checkBox3.isChecked) {
                textView.append("세 번째 체크 박스 체크\n")
            }else {
                textView.append("세 번째 체크 박스 해제\n")
            }
        }

        button2.setOnClickListener {
            checkBox.isChecked = true
            checkBox2.isChecked = true
            checkBox3.isChecked = true
        }

        button3.setOnClickListener {
            checkBox.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
        }

        button4.setOnClickListener {
            checkBox.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }
        checkBox.setOnCheckedChangeListener(listener1)
        checkBox2.setOnCheckedChangeListener(listener1)
        checkBox3.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                textView.text = "세 번째 체크박스 체크"
            } else {
                textView.text = "세 번째 체크박스 해제"
            }
        }
    }
    private val listener1 = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        when(buttonView?.id){
            R.id.checkBox -> {
                if(isChecked) {
                    textView.text = "첫 번째 체크박스 체크"
                } else {
                    textView.text = "첫 번째 체크박스 해제"
                }
            }
            R.id.checkBox2 -> {
                if(isChecked) {
                    textView.text = "두 번째 체크박스 체크"
                } else {
                    textView.text = "두 번째 체크박스 해제"
                }
            }
        }
    }
}
package com.elliot.step06sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. SharedPreference 생성하기
        val sp = getSharedPreferences("firstSP", Context.MODE_PRIVATE)
        // 2. Editor 꺼내기
        val editor = sp.edit()

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)

        val saveBtn = findViewById<Button>(R.id.saveBtn)
        saveBtn.setOnClickListener {
            // 3. putString() 메서드로 저장하기
            editor.putString("name", editText.text.toString())
            // 4. apply()로 파일에 반영하기
            editor.apply()
        }

        val showBtn = findViewById<Button>(R.id.showBtn)
        showBtn.setOnClickListener {
            // 5. getString() 메서드로 값 읽어오기
            textView.text = sp.getString("name", null)
        }
    }
}
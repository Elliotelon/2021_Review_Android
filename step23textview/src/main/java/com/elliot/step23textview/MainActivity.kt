package com.elliot.step23textview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.elliot.step23textview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null

    private val binding get() = mBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //뷰의 주소 값을 얻어온다
        val text1 = findViewById<TextView>(R.id.text1)
        text1.text="안녕하세요"

        binding?.text2?.text = "반갑습니다."

        //binding?.text2?.setBackgroundColor(Color.RED)
        //binding?.text2?.setBackgroundColor(Color.rgb(100, 100, 100))
        binding?.text2?.setBackgroundColor(Color.argb(100, 100, 100, 100))

        binding?.text2?.setTextColor(Color.BLUE)

        binding?.text2?.append("\n감사합니다.")






    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}
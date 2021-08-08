package com.elliot.step01service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val startBtn by lazy {findViewById<Button>(R.id.start_btn)}
    private val stopBtn by lazy {findViewById<Button>(R.id.stop_btn)}
    private val serviceIntent by lazy { Intent(this, MyService::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //서비스 시작 버튼 클릭시 호출
        startBtn.setOnClickListener {

            //Intent 값 넘겨주기
            serviceIntent.putExtra("Number", 1000)

            //startService 호출시 MyService 클래스의 onStartCommand 가 자동으로 호출된다.
            startService(serviceIntent)
        }

        //서비스중지 버튼 클릭시 호출
        stopBtn.setOnClickListener {

            //stopService 호출시 MyService 클래스의 onDestroy 가 자동으로 호출된다.
            stopService(serviceIntent)
        }
    }

    //Activity 종료시 stopService 가 호출되므로 MyService 클래스의 onDestroy 가 자동으로 호출된다.
    override fun onDestroy() {
        stopService(serviceIntent)
        super.onDestroy()
    }
}
package com.elliot.step02broadcastreceiver1

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val brButton by lazy {findViewById<Button>(R.id.brButton)}

    //BroadcastReceiver 객체 생성
    val br = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // 안드로이드 8.0 버전 이상에서는 코드로 IntentFilter 등록을 해주어야한다.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val filter = IntentFilter("com.elliot.testbr")
            registerReceiver(br, filter)
        }

        //버튼 클릭시 송신하기
        brButton.setOnClickListener {

            val intent = Intent("com.elliot.testbr")
            sendBroadcast(intent)
        }
    }

    // 안드로이드 8.0 버전 이상에서는 코드로 IntentFilter 해제 해주어야한다.
    override fun onDestroy() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            unregisterReceiver(br)
        }
        super.onDestroy()
    }
}
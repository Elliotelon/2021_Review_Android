package com.elliot.step01service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    var isRunning = false

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    // startService 호출시 자동으로 호출되는 메소드
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        //MainActivity startBtn 클릭시 넘어온 Intent 값 추출
        Log.d("onStartCommand", intent?.getIntExtra("Number",0).toString())

        //Thread 실행을 위해 isRunning 값을 true로 변경
        isRunning = true

        //람다식 형태로 Thread 호출
        Thread{
            var i = 0
            while (isRunning){
                Log.d("onStartCommand", "$i")
                i++
                //Thread 1초 지연시키기
                Thread.sleep(1000)
            }
        }.start() //Thread 시작메소드


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("onStartCommand", "서비스 종료")
        //백그라운드 작업(thread)을 종료 시키기 위해 isRunning 값을 false로 변경
        isRunning = false
        super.onDestroy()
    }
}
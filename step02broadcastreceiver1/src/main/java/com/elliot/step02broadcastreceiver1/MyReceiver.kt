package com.elliot.step02broadcastreceiver1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    //sendBroadcast() 호출시 자동으로 호출되는 메소드
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context, "BR테스트입니다.", Toast.LENGTH_SHORT).show()
    }
}
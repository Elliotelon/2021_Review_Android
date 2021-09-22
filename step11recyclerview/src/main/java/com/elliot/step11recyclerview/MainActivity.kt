package com.elliot.step11recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileList = arrayListOf(
            Profiles(R.drawable.man, "사람0", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "사람1", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "사람2", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "사람3", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "사람4", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "사람5", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "사람6", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "사람7", 27, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "사람8", 27, "안드로이드 앱 개발자")
        )

        val rv_profile = findViewById<RecyclerView>(R.id.rv_profile)
        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_profile.setHasFixedSize(true)

        rv_profile.adapter = ProfileAdapter(profileList)

    }
}
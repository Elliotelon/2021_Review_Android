package com.elliot.step04jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. JSON 파일 열어서 String으로 취득
        val jsonString = assets.open("data.json").reader().readText()
        Log.d("jsonString", jsonString)

        // 2. JSONArray 로 파싱
        val jsonArray = JSONArray(jsonString)
        Log.d("jsonArray", jsonArray.toString())

        // 3. JSONArray 순회: 인덱스별 JsonObject 취득후, key에 해당하는 value 확인
        for (index in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(index)
            val id = jsonObject.getString("id")
            val language = jsonObject.getString("language")
            Log.d("jsonObject", jsonObject.toString())
            Log.d("json_id_language", "$id $language")
        }
    }
}


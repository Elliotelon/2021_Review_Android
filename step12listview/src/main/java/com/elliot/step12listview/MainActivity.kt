package com.elliot.step12listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.elliot.step12listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list_item = mutableListOf<ListViewModel>()

        list_item.add(ListViewModel("리스트1"))
        list_item.add(ListViewModel("리스트2"))
        list_item.add(ListViewModel("리스트3"))

        // Adapter로 데이터 전달
        val adapter = ListViewAdapter(this, list_item)
        binding.listViewTest.adapter = adapter



    }

}
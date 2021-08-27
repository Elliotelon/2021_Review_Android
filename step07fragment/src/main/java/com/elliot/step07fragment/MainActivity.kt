package com.elliot.step07fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elliot.step07fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    /*
    * when flag is 0 : 처음
    * when flag is 1 : FragmentA
    * when flag is 2 : FragmentB
    * */
    var flag = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnSwitch.setOnClickListener {
            switchFragment()
        }
        binding.btnRemove.setOnClickListener {
            removeFragment()
        }
    }
    private fun switchFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        when(flag){
            0 -> {
                transaction.add(R.id.frameLayout, FragmentA())
                flag = 1
            }
            1 -> {
                transaction.replace(R.id.frameLayout, FragmentB())
                flag = 2
            }
            2 -> {
                transaction.replace(R.id.frameLayout, FragmentA())
                flag = 1
            }
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun removeFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val frameLayout = supportFragmentManager.findFragmentById(R.id.frameLayout)
        transaction.remove(frameLayout!!)
        transaction.commit()
    }
}
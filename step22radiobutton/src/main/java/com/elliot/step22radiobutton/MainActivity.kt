package com.elliot.step22radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}

    private val radioGroup1 by lazy {findViewById<RadioGroup>(R.id.radioGroup1)}
    private val radioGroup2 by lazy {findViewById<RadioGroup>(R.id.radioGroup2)}

    private val radioButton by lazy {findViewById<RadioButton>(R.id.radioButton)}
    private val radioButton2 by lazy {findViewById<RadioButton>(R.id.radioButton2)}
    private val radioButton3 by lazy {findViewById<RadioButton>(R.id.radioButton3)}
    private val radioButton4 by lazy {findViewById<RadioButton>(R.id.radioButton4)}
    private val radioButton5 by lazy {findViewById<RadioButton>(R.id.radioButton5)}
    private val radioButton6 by lazy {findViewById<RadioButton>(R.id.radioButton6)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            radioButton3.isChecked = true
            radioButton6.isChecked = true
        }

        button2.setOnClickListener {
            when(radioGroup1.checkedRadioButtonId) {
                R.id.radioButton->{
                    textView.text = "라디오 1-1이 체크 되어있습니다."
                }
                R.id.radioButton2->{
                    textView.text = "라디오 1-2가 체크 되어있습니다."
                }
                R.id.radioButton3->{
                    textView.text = "라디오 1-3이 체크 되어있습니다."
                }
            }

            when(radioGroup2.checkedRadioButtonId) {
                R.id.radioButton4->{
                    textView2.text = "라디오 2-1이 체크 되어있습니다."
                }
                R.id.radioButton5->{
                    textView2.text = "라디오 2-2가 체크 되어있습니다."
                }
                R.id.radioButton6->{
                    textView2.text = "라디오 2-3이 체크 되어있습니다."
                }
            }
        }

        radioGroup1.setOnCheckedChangeListener(listener1)
        radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.radioButton4->{
                    textView2.text = "라디오 2-1이 체크 되어있습니다."
                }
                R.id.radioButton5->{
                    textView2.text = "라디오 2-2가 체크 되어있습니다."
                }
                R.id.radioButton6->{
                    textView2.text = "라디오 2-3이 체크 되어있습니다."
                }
            }
        }
    }

    private val listener1 = RadioGroup.OnCheckedChangeListener { group, checkedId ->
        when(group?.id) {
            R.id.radioGroup1 -> {
                when(checkedId) {
                    R.id.radioButton->{
                        textView.text = "라디오 1-1이 체크 되어있습니다."
                    }
                    R.id.radioButton2->{
                        textView.text = "라디오 1-2가 체크 되어있습니다."
                    }
                    R.id.radioButton3->{
                        textView.text = "라디오 1-3이 체크 되어있습니다."
                    }
                }
            }
        }
    }
}
package com.elliot.step15seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}
    private val button3 by lazy {findViewById<Button>(R.id.button3)}
    private val button4 by lazy {findViewById<Button>(R.id.button4)}

    private val seekBar by lazy {findViewById<SeekBar>(R.id.seekBar)}
    private val seekBar2 by lazy {findViewById<SeekBar>(R.id.seekBar2)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "SeekBar1 : ${seekBar.progress}"
            textView2.text = "SeekBar2 : ${seekBar2.progress}"
        }

        button2.setOnClickListener {
            seekBar.progress = 3
            seekBar2.progress = 8
        }

        button3.setOnClickListener {
            seekBar.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }

        button4.setOnClickListener {
            seekBar.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }

        seekBar.setOnSeekBarChangeListener(listener1)
        seekBar2.setOnSeekBarChangeListener(listener1)
    }

    val listener1 = object : SeekBar.OnSeekBarChangeListener {

        // ProgressBar의 값이 변경 되었을때
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            when(seekBar?.id){
                R.id.seekBar -> {
                    textView.text = "첫 번째 SeekBar ${progress}로 설정되었습니다.\n"
                }

                R.id.seekBar2 -> {
                    textView.text = "두 번째 SeekBar ${progress}로 설정되었습니다.\n"
                }
            }

            if(fromUser == true){
                textView.append("사용자에 의해 설정되었습니다.")
            }else{
                textView.append("코드를 통해 설정 되었습니다.")
            }
        }

        // 사용자가 터치 했을 때
        override fun onStartTrackingTouch(seekBar: SeekBar?) {
            when(seekBar?.id){
                R.id.seekBar -> {
                    textView2.text = "첫 번째 SeekBar 사용자 터치 시작"
                }
                R.id.seekBar2 -> {
                    textView2.text = "두 번째 SeekBar 사용자 터치 시작"
                }
            }
        }

        // 사용자가 터치를 끝냈을 때
        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            when(seekBar?.id){
                R.id.seekBar -> {
                    textView2.text = "첫 번째 SeekBar 사용자 터치 끝"
                }
                R.id.seekBar2 -> {
                    textView2.text = "두 번째 SeekBar 사용자 터치 끝"
                }
            }
        }

    }
}
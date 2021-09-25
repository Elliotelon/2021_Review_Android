package com.elliot.step14ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val ratingBar by lazy {findViewById<RatingBar>(R.id.ratingBar)}
    private val ratingBar2 by lazy {findViewById<RatingBar>(R.id.ratingBar2)}
    private val ratingBar3 by lazy {findViewById<RatingBar>(R.id.ratingBar3)}
    private val ratingBar4 by lazy {findViewById<RatingBar>(R.id.ratingBar4)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}
    private val textView2 by lazy {findViewById<TextView>(R.id.textView2)}
    private val textView3 by lazy {findViewById<TextView>(R.id.textView3)}

    private val button by lazy {findViewById<Button>(R.id.button)}
    private val button2 by lazy {findViewById<Button>(R.id.button2)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Rating 1 : ${ratingBar.rating}\n"
            textView.append("Rating 2 : ${ratingBar2.rating}\n")
            textView.append("Rating 3 : ${ratingBar3.rating}\n")
            textView.append("Rating 4 : ${ratingBar4.rating}\n")
        }

        button2.setOnClickListener {
            ratingBar.rating = 1.0f
            ratingBar2.rating = 2.0f
            ratingBar3.rating = 3.0f
            ratingBar4.rating = 4.0f
        }

        ratingBar2.onRatingBarChangeListener = listener1
        ratingBar3.onRatingBarChangeListener = listener1

        ratingBar4.setOnRatingBarChangeListener { _, rating, fromUser ->
            textView3.text = "Rating 4 : ${rating}\n"

            if(fromUser){
                textView3.append("사용자에 의해 설정 되었습니다.")
            }else{
                textView3.append("코드를 통해 설정 되었습니다.")
            }
        }

    }

    private val listener1 =
        RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            when(ratingBar?.id){
                R.id.ratingBar2 -> {
                    textView.text = "Rating 2 : ${rating}\n"
                    if(fromUser){
                        textView.append("사용자에 의해 설정 되었습니다.")
                    }else{
                        textView.append("코드를 통해 설정 되었습니다.")
                    }
                }
                R.id.ratingBar3 -> {
                    textView2.text = "Rating 3 : ${rating}\n"
                    if(fromUser){
                        textView2.append("사용자에 의해 설정 되었습니다.")
                    }else{
                        textView2.append("코드를 통해 설정 되었습니다.")
                    }
                }
            }
        }
}
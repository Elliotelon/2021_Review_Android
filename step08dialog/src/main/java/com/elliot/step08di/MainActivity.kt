package com.elliot.step08di

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    var pro: ProgressDialog? = null
    private val btn1 by lazy { findViewById<Button>(R.id.btn1) }
    private val btn2 by lazy { findViewById<Button>(R.id.btn2) }
    private val btn3 by lazy { findViewById<Button>(R.id.btn3) }
    private val btn4 by lazy { findViewById<Button>(R.id.btn4) }
    private val btn5 by lazy { findViewById<Button>(R.id.btn5) }

    private val tv1 by lazy { findViewById<TextView>(R.id.tv1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 기본 다이얼로그
        btn1.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이얼로그")
            builder.setMessage("기본 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            // 버튼 클릭시에 무슨 작업을 할 것인가!
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE ->
                            tv1.text = "BUTTON_POSITIVE"
                        DialogInterface.BUTTON_NEUTRAL ->
                            tv1.text = "BUTTON_NEUTRAL"
                        DialogInterface.BUTTON_NEGATIVE ->
                            tv1.text = "BUTTON_NEGATIVE"
                    }
                }
            }

            builder.setPositiveButton("Positive", listener)
            builder.setNegativeButton("Negative", listener)
            builder.setNeutralButton("Neutral", listener)

            builder.show()
        }

        // 2. 커스텀 다이얼로그
        btn2.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            var v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            // p0에 해당 AlertDialog가 들어온다. findViewById를 통해 view를 가져와서 사용
            var listener = DialogInterface.OnClickListener { p0, p1 ->
                var alert = p0 as AlertDialog
                var edit1: EditText? = alert.findViewById<EditText>(R.id.editText)
                var edit2: EditText? = alert.findViewById<EditText>(R.id.editText2)

                tv1.text = "${edit1?.text}"
                tv1.append("${edit2?.text}")
            }

            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", null)

            builder.show()
        }

        // 3. 날짜 다이얼로그
        btn3.setOnClickListener {
            var calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            var listener = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                // i년 i2월 i3일
                tv1.text = "${i}년 ${i2 + 1}월 ${i3}일"
            }

            var picker = DatePickerDialog(this, listener, year, month, day)
            picker.show()
        }

        // 4. 시간 다이얼로그
        btn4.setOnClickListener {
            var calendar = Calendar.getInstance()
            var hour = calendar.get(Calendar.HOUR)
            var minute = calendar.get(Calendar.MINUTE)

            var listener = TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                tv1.text = "${i}시 ${i2}분"
            }

            var picker = TimePickerDialog(this, listener, hour, minute, false ) // true하면 24시간 제
            picker.show()
        }

        // 5. 프로그레스 다이얼로그
        btn5.setOnClickListener {
            // 권장하진 않지만 사용은 가능하다.
            pro = ProgressDialog.show(this, "타이틀입니다.", "메시지입니다.")

            // 핸들러를 통해서 종료 작업을 한다.
            var handler = Handler()
            var thread = Runnable { pro?.cancel() }
            handler.postDelayed(thread,5000) // 딜레이는 5초
        }
    }
}
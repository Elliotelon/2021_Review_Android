package com.elliot.step21chip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class MainActivity : AppCompatActivity() {

    private val chip1 by lazy {findViewById<Chip>(R.id.chip1)}
    private val chip3 by lazy {findViewById<Chip>(R.id.chip3)}
    private val chip4 by lazy {findViewById<Chip>(R.id.chip4)}
    private val chip5 by lazy {findViewById<Chip>(R.id.chip5)}

    private val chipGroup1 by lazy {findViewById<ChipGroup>(R.id.chipGroup1)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chip1.setOnClickListener {
            textView.text = "첫 번째 Chip을 클릭하였습니다."

            if(chip3.isChecked) {
                textView.append("두 번째 chip이 선택되었습니다.\n")
            } else {
                textView.append("두 번째 chip이 선택 되지 않았습니다.\n")
            }

            if(chip4.isChecked) {
                textView.append("세 번째 chip이 선택되었습니다.\n")
            } else {
                textView.append("세 번째 chip이 선택되어 있지 않습니다.\n")
            }

            if(chip5.isChecked) {
                textView.append("네 번째 Chip이 선택되었습니다.\n")
            } else {
                textView.append("네 번째 Chip이 선택되어 있지 않습니다.\n")
            }

            when(chipGroup1.checkedChipId){
                R.id.chip6 -> {
                    textView.append("그룹내의 첫번째 Chip이 선택되어 있습니다.\n")
                }
                R.id.chip7 -> {
                    textView.append("그룹내의 두번째 Chip이 선택되어 있습니다.\n")
                }
                R.id.chip8 -> {
                    textView.append("그룹내의 세번째 Chip이 선택되어 있습니다.\n")
                }
            }
        }

        chip4.setOnCloseIconClickListener {
            textView.text = "닫기 버튼을 눌렀습니다."
        }

        chip5.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                textView.text = "네 번째 Chip이 체크 되었습니다."
            } else {
                textView.text = "네 번째 Chip이 체크 해제 되었습니다."
            }
        }
    }
}
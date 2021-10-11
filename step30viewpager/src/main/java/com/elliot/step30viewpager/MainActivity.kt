package com.elliot.step30viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private val pager1 by lazy {findViewById<ViewPager>(R.id.pager1)}

    private val textView by lazy {findViewById<TextView>(R.id.textView)}

    //ViewPager를 통해 보여줄 View들을 담을 리스트
    val viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view1 = layoutInflater.inflate(R.layout.view1, null)
        val view2 = layoutInflater.inflate(R.layout.view2, null)
        val view3 = layoutInflater.inflate(R.layout.view3, null)
        val view4 = layoutInflater.inflate(R.layout.view1, null)
        val view5 = layoutInflater.inflate(R.layout.view2, null)
        val view6 = layoutInflater.inflate(R.layout.view3, null)

        viewList.add(view1)
        viewList.add(view2)
        viewList.add(view3)
        viewList.add(view4)
        viewList.add(view5)
        viewList.add(view6)

        val adapter = object : PagerAdapter(){

            //ViewPager가 보여줄 View의 개수
            override fun getCount(): Int {
                return viewList.size
            }

            // instantiateItem이 반환한 객체를 화면으로 사용할 것인가를 검사하는 메소드
            override fun isViewFromObject(view: View, obj: Any): Boolean {
                return view == obj
            }

            //ViewPager가 보여줄 View를 반환한다.
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                pager1.addView(viewList[position])
                return viewList[position]
            }

            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                pager1.removeView(obj as View)
            }

        }
        pager1.adapter = adapter

        val listener1 = object : ViewPager.OnPageChangeListener{

            //페이지 스크롤이 끝났을 때 호출되는 메소드
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                textView.text = "$position 번째 View가 나타났습니다."
            }

            // 페이지를 선택했을때 호출되는 메소드
            override fun onPageSelected(position: Int) {
            }

            //페이지의 스크롤 상태가 변경되었을때 호출되는 메소드
            override fun onPageScrollStateChanged(state: Int) {
            }

        }
        pager1.addOnPageChangeListener(listener1)
    }
}
package com.example.kotlinspinnerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("스피너1-1", "스피너1-2", "스피너1-3", "스피너1-4")
    var data2 = arrayOf("스피너2-1", "스피너2-2", "스피너2-3", "스피너2-4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)

        sp1.adapter = adapter1
        sp2.adapter = adapter2

        var listener1 = SpinnerListener1()
        sp1.onItemSelectedListener = listener1
//        var listener2 = SpinnerListener2()
//        sp2.onItemSelectedListener = listener2
        sp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tv.text = data2[position]
            }
        }

    }

    inner class SpinnerListener1: AdapterView.OnItemSelectedListener{
        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            tv.text = data1[position]
        }
    }

    inner class SpinnerListener2: AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            tv.text = data2[position]
        }
    }
}

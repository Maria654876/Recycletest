package com.example.recycletest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.recycletest.R

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var texrresult:String= intent.getStringExtra("result").toString()
        var textViw : String=intent.getStringExtra("text").toString()

        val textview : TextView = findViewById(R.id.textView11) as TextView
        textview.setText(texrresult)

        val textView2: TextView = findViewById(R.id.textView13) as TextView
        textView2.setText(textViw)
    }
}
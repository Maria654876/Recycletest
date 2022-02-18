package com.example.recycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.recycletest.activity.EightActivity
import com.example.recycletest.activity.NineActivity
import com.example.recycletest.activity.SevenActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button7 = findViewById<Button>(R.id.appCompatButton7)
        button7.setOnClickListener {
            val intent = Intent(this, SevenActivity::class.java)
            startActivity(intent)
        }

        val button8 = findViewById<Button>(R.id.appCompatButton8)
        button8.setOnClickListener {
            val intent = Intent(this, EightActivity::class.java)
            startActivity(intent)
        }

        val button9 = findViewById<Button>(R.id.appCompatButton9)
        button9.setOnClickListener {
            val intent = Intent(this, NineActivity::class.java)
            startActivity(intent)
        }
    }
}
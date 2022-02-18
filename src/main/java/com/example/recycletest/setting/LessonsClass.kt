package com.example.recycletest.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.recycletest.R

class LessonsClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons_class)

        val headingLessons : TextView = findViewById(R.id.heading)
        val mainLess : TextView = findViewById(R.id.less)
        val imageLess : ImageView = findViewById(R.id.imageView)

        val bundle: Bundle?=intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val lesson = bundle.getString("lessons")

        headingLessons.text = heading
        mainLess.text = lesson
        imageLess.setImageResource(imageId)

    }
}
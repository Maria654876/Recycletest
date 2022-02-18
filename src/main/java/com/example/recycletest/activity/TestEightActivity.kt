package com.example.recycletest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycletest.R
import kotlinx.android.synthetic.main.activity_test.buttontr
import kotlinx.android.synthetic.main.activity_test.rg1
import kotlinx.android.synthetic.main.activity_test.rg2
import kotlinx.android.synthetic.main.activity_test.rg3
import kotlinx.android.synthetic.main.activity_test.rg4
import kotlinx.android.synthetic.main.activity_test.rg5
import kotlinx.android.synthetic.main.activity_test.rg6
import kotlinx.android.synthetic.main.activity_test.rg7
import kotlinx.android.synthetic.main.activity_test_eight.*

class TestEightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_eight)

        var count:Int
        lateinit var mistak :String
        count=0
        rg1.setOnCheckedChangeListener { _gr1, checkedId ->
            if(checkedId== R.id.rb2) {
                count++
            }
        }
        rg2.setOnCheckedChangeListener { group2, checkedId ->
            if(checkedId== R.id.rb6) {
                count++
            }
        }
        rg3.setOnCheckedChangeListener { group3, checkedId ->
            if(checkedId== R.id.rb9) {
                count++
            }
        }
        rg4.setOnCheckedChangeListener { group4, checkedId ->
            if(checkedId== R.id.rb11) {
                count++
            }
        }
        rg5.setOnCheckedChangeListener { group5, checkedId ->
            if(checkedId== R.id.rb13) {
                count++
            }
        }
        rg6.setOnCheckedChangeListener { group6, checkedId ->
            if(checkedId== R.id.rb17) {
                count++
            }
        }
        rg7.setOnCheckedChangeListener { group7, checkedId ->
            if(checkedId== R.id.rb19) {
                count++
            }

        }
        rg8.setOnCheckedChangeListener { group8, checkedId ->
            if(checkedId== R.id.rb24) {
                count++
            }

        }
        rg9.setOnCheckedChangeListener { group9, checkedId ->
            if(checkedId== R.id.rb26) {
                count++
            }

        }
        rg10.setOnCheckedChangeListener { group10, checkedId ->
            if(checkedId== R.id.rb30) {
                count++
            }
        }

        if (count in 0..3){
            mistak=("Плохо, повторите материал и попробуйте снова!")
        }else if(count in 4..6){
            mistak=("Хорошо, продолжайте в том же духе!")
        }else if(count in 7..10){
            mistak=("Отлично, вы хорошо усвоили материал!")
        }


        buttontr.setOnClickListener {

            val text = count.toString()

            val intent = Intent(this, Result::class.java)
            intent.putExtra("result",text)
            intent.putExtra("text",mistak.toString())
            startActivity(intent)

        }
    }
}
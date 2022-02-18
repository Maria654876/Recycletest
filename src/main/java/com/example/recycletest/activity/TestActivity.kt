package com.example.recycletest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycletest.R
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


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
                    if(checkedId== R.id.rb7) {
                        count++
                    }
                }
                rg4.setOnCheckedChangeListener { group4, checkedId ->
                    if(checkedId== R.id.rb12) {
                        count++
                    }
                }
                rg5.setOnCheckedChangeListener { group5, checkedId ->
                    if(checkedId== R.id.rb15) {
                        count++
                    }
                }
                rg6.setOnCheckedChangeListener { group6, checkedId ->
                    if(checkedId== R.id.rb18) {
                        count++
                    }
                }
                rg7.setOnCheckedChangeListener { group7, checkedId ->
                    if(checkedId== R.id.rb19) {
                    count++
                }

                    if (count in 0..2){
                        mistak=("Плохо, повторите материал и попробуйте снова!")
                    }else if(count in 3..5){
                        mistak=("Хорошо, продолжайте в том же духе!")
                    }else if(count in 6..7){
                        mistak=("Отлично, вы хорошо усвоили материал!")
                    }

            }


            buttontr.setOnClickListener {

                val texts = count.toString()

                val intent = Intent(this, Result::class.java)
                intent.putExtra("result",texts)
                intent.putExtra("text",mistak.toString())
                startActivity(intent)

            }
    }
}
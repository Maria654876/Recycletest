package com.example.recycletest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycletest.R
import com.example.recycletest.setting.Lessons
import com.example.recycletest.setting.LessonsClass
import com.example.recycletest.sevenClass.SevenAdapter
import java.util.*
import kotlin.arrayOf
import kotlin.collections.ArrayList

class SevenActivity : AppCompatActivity() {

    private lateinit var recycler : RecyclerView
    private lateinit var newArrayList: ArrayList<Lessons>
    private lateinit var tempArrayList: ArrayList<Lessons>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var lesson :Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven)

        val buttontest = findViewById<Button>(R.id.buttontest)
        buttontest.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

        imageId = arrayOf(
            R.drawable.itemsevenzero,
            R.drawable.itemseven1,
            R.drawable.itemseven2,
            R.drawable.itemseven3,
            R.drawable.itemseven4,
            R.drawable.itemseven5,
            R.drawable.itemseven6,
            R.drawable.itemseven7,
            R.drawable.itemseven8,
            R.drawable.itemseven9,
            R.drawable.itemseven10,
            R.drawable.itemseven11,
            R.drawable.itemseven12
        )

        heading = arrayOf(
            "Простейшие геометрические фигуры и их свойства",
            "Углы",
            "Параллельные прямые",
            "Треугольник",
            "Признаки равенства треугольников",
            "Соотношения между сторонами и углами треугольника",
            "Определение вида треугольника по его сторонам",
            "Прямоугольные треугольники (некоторые свойства)",
            "Признаки равенства прямоугольных треугольников",
            "Четыре замечательные точки треугольника",
            "Окружность",
            "Свойства касательных к окружности",
            "Окружность и треугольник"
        )

        lesson = arrayOf(
            getString(R.string.item0),
            getString(R.string.item1),
            getString(R.string.item2),
            getString(R.string.item3),
            getString(R.string.item4),
            getString(R.string.item5),
            getString(R.string.item6),
            getString(R.string.item7),
            getString(R.string.item8),
            getString(R.string.item9),
            getString(R.string.item10),
            getString(R.string.item11),
            getString(R.string.item12)
        )

        recycler = findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        newArrayList = arrayListOf<Lessons>()
        tempArrayList = arrayListOf<Lessons>()
        getUserdata()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_item, menu)
        val itemse = menu?.findItem(R.id.search)
        val searchView = itemse?.actionView as SearchView


        searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               tempArrayList.clear()
                val searchtext = newText!!.toLowerCase(Locale.getDefault())
                if (searchtext.isNotEmpty()){
                    newArrayList.forEach(){
                        if(it.name.toLowerCase(Locale.getDefault()).contains(searchtext)){
                            tempArrayList.add(it)
                        }
                    }

                    recycler.adapter!!.notifyDataSetChanged()
                }else{

                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    recycler.adapter!!.notifyDataSetChanged()

                }
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun getUserdata(){
        for(i in imageId.indices){

            val lesson = Lessons(heading [i],imageId[i])
            newArrayList.add(lesson)
        }

        tempArrayList.addAll(newArrayList)

        var adapter = SevenAdapter(tempArrayList)
        recycler.adapter = adapter
        adapter.setOnItemClickListener(object  : SevenAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent (this@SevenActivity, LessonsClass::class.java)
                intent.putExtra("heading", newArrayList[position].name)
                intent.putExtra("imageId",newArrayList[position].image)
                intent.putExtra("lessons",lesson[position])
                startActivity(intent)
            }

        })

    }

}
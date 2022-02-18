package com.example.recycletest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycletest.R
import com.example.recycletest.nineClass.NineAdapter
import com.example.recycletest.setting.Lessons
import com.example.recycletest.setting.LessonsClass
import java.util.*
import kotlin.collections.ArrayList

class NineActivity : AppCompatActivity() {

    private lateinit var recycler : RecyclerView
    private lateinit var newArrayList: ArrayList<Lessons>
    private lateinit var tempArrayList: ArrayList<Lessons>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var lesson :Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine)

        val buttontest = findViewById<Button>(R.id.buttontest)
        buttontest.setOnClickListener {
            val intent = Intent(this, TestNineActivity::class.java)
            startActivity(intent)
        }


        imageId = arrayOf(
            R.drawable.itemziro,
            R.drawable.itemone,
            R.drawable.itemtwo,
            R.drawable.nineitem3,
            R.drawable.nineitem4,
            R.drawable.nineitem5,
            R.drawable.nineitem6,
            R.drawable.nineitem7,
            R.drawable.nineitem8,
            R.drawable.nineitem9,
            R.drawable.nineitem10,
            R.drawable.nineitem12,
            R.drawable.nineitem14,
            R.drawable.nineitem15
        )

        heading = arrayOf(
            "Разложение вектора по двум неколлинеарным a и b",
            "Декартовы координаты на плоскости",
            "Действия над векторами",
            "Нахождение координат вектора AB",
            "Расстояние между двумя точками",
            "Уравнение окружности",
            "Координаты середины отрезка",
            "Теорема синусов и косинусов",
            "Скалярное произведение векторов",
            "Скалярное произведение векторов, заданных в координатах",
            "Уравнение прямой в общем виде ax + by = c, где a,b,c – числа",
            "Формулы для правильного многоугольника",
            "Многогранники",
            "Тела вращения",
        )

        lesson = arrayOf(
            getString(R.string.itemnine0),
            getString(R.string.itemnine1),
            getString(R.string.itemenine2),
            getString(R.string.itemnine3),
            getString(R.string.itemnine4),
            getString(R.string.itemnine5),
            getString(R.string.itemnine6),
            getString(R.string.itemenine7),
            getString(R.string.itemnine8),
            getString(R.string.itemenine9),
            getString(R.string.itemenine10),
            getString(R.string.itemnine12),
            getString(R.string.itemnine13),
            getString(R.string.itemnine14)
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

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
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
                return true            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun getUserdata(){
        for(i in imageId.indices){

            val lesson = Lessons(heading [i],imageId[i])
            newArrayList.add(lesson)
        }

        tempArrayList.addAll(newArrayList)

        var adapter = NineAdapter(tempArrayList)
        recycler.adapter = adapter
        adapter.setOnItemClickListener(object  : NineAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent (this@NineActivity, LessonsClass::class.java)
                intent.putExtra("heading", newArrayList[position].name)
                intent.putExtra("imageId",newArrayList[position].image)
                intent.putExtra("lessons",lesson[position])
                startActivity(intent)
            }

        })

    }


}
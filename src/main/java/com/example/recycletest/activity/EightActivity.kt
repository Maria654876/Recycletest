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
import kotlin.collections.ArrayList

class EightActivity : AppCompatActivity() {

    private lateinit var recycler : RecyclerView
    private lateinit var newArrayList: ArrayList<Lessons>
    private lateinit var tempArrayList: ArrayList<Lessons>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var lesson :Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight)

        val buttontest = findViewById<Button>(R.id.buttontest)
        buttontest.setOnClickListener {
            val intent = Intent(this, TestEightActivity::class.java)
            startActivity(intent)
        }


        imageId = arrayOf(
            R.drawable.eightitem,
            R.drawable.eightitem2,
            R.drawable.eightitem3,
            R.drawable.eightitem4,
            R.drawable.eightitem5,
            R.drawable.eightitem6,
            R.drawable.eightitem7,
            R.drawable.eightitem8,
            R.drawable.eightitem9,
            R.drawable.eightitem10,
            R.drawable.eightitem11,
            R.drawable.eightitem12,
            R.drawable.eightitem13,
            R.drawable.eightitem14,
            R.drawable.eightitem15,
            R.drawable.eightitem16,
            R.drawable.eightitem17,
            R.drawable.eightitem18,
            R.drawable.eightitem19,
            R.drawable.eightitem20,
            R.drawable.eightitem21,
            R.drawable.eightitem22,
            R.drawable.eightitem24,
        )

        heading = arrayOf(
        "Многоугольник",
        "Правильные многоугольники",
        "Четырехугольник",
        "Параллелограмм",
        "Трапеция",
        "Прямоугольник",
        "Ромб",
        "Квадрат",
        "Теорема Чевы",
        "Теорема Менедая",
        "Теорема синусов",
        "Теорема косинусов",
        "Площадь треугольника",
        "Равносторонний (правильный) треугольник",
        "Подобные треугольники",
        "Признаки подобия треугольников",
        "Окружность",
        "Свойства касательных к окружности",
        "Окружность и треугольник",
        "Окружность и четырехугольник",
        "Углы и окружность",
        "Метрические соотношения в окружности",
        "Длина окружности. Площадь круга и его частей",
        )

        lesson = arrayOf(
            getString(R.string.itemeight0),
            getString(R.string.itemeight1),
            getString(R.string.itemeight2),
            getString(R.string.itemeight3),
            getString(R.string.itemeight4),
            getString(R.string.itemeight5),
            getString(R.string.itemeight6),
            getString(R.string.itemeight7),
            getString(R.string.itemeight8),
            getString(R.string.itemeight9),
            getString(R.string.itemeight10),
            getString(R.string.itemeight11),
            getString(R.string.itemeight12),
            getString(R.string.itemeight13),
            getString(R.string.itemeight14),
            getString(R.string.itemeight15),
            getString(R.string.itemeight17),
            getString(R.string.itemeight18),
            getString(R.string.itemeight19),
            getString(R.string.itemeight20),
            getString(R.string.itemeight21),
            getString(R.string.itemeight22),
            getString(R.string.itemeight23),

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

    private fun getUserdata() {
        for (i in imageId.indices) {

            val lesson = Lessons(heading[i], imageId[i])
            newArrayList.add(lesson)
        }

        tempArrayList.addAll(newArrayList)

        var adapter = SevenAdapter(tempArrayList)
        recycler.adapter = adapter
        adapter.setOnItemClickListener(object : SevenAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(this@EightActivity, LessonsClass::class.java)
                intent.putExtra("heading", newArrayList[position].name)
                intent.putExtra("imageId", newArrayList[position].image)
                intent.putExtra("lessons", lesson[position])
                startActivity(intent)
            }

        })
    }
}
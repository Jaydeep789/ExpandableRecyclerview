package com.example.expandablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.RotateAnimation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerview.Adapters.MyAdapter1
import com.example.expandablerecyclerview.Adapters.MyAdapter2
import com.example.expandablerecyclerview.Model.Model1
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item1.*
import kotlinx.android.synthetic.main.recyclerview2.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter1 : MyAdapter1

    val list1 = ArrayList<Model1>()
    lateinit var rotation : RotateAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        retrieveData()
    }

    private fun retrieveData() {
        list1.apply {
            add(Model1("Home Services"))
            add(Model1("Health & Fitness"))
            add(Model1("Beauty & Spas"))
            add(Model1("Personal Services"))
            add(Model1("Things To Do"))
            add(Model1("Automotive"))
            add(Model1("Retail"))
            add(Model1("Food & Drink"))
        }
        adapter1.setList1(list1)
    }

    private fun init() {
        recyclerview1.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter1 = MyAdapter1()
            adapter = adapter1
        }
    }
}

package com.example.expandablerecyclerview.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerview.Model.Model1
import com.example.expandablerecyclerview.R
import kotlinx.android.synthetic.main.list_item2.view.*
import kotlinx.android.synthetic.main.recyclerview3.view.*

class MyAdapter2 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var modelList2: List<Model1> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder1(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return modelList2.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MyViewHolder1 -> {
                holder.bind(modelList2[position])
            }
        }
    }

    fun setList2(list: List<Model1>) {
        modelList2 = list
    }

    class MyViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text2 = itemView.textview2
        val expandable2 = itemView.expandable2
        val recyclerView3 = itemView.recyclerview3
        val image2 = itemView.image2
        lateinit var adapter3: MyAdapter3
        val list3 = ArrayList<Model1>()

        fun bind(model1: Model1) {
            text2.text = model1.name
            image2.setOnClickListener {

                recyclerView3.apply {
                    layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.VERTICAL,false)
                    adapter3 = MyAdapter3()
                    adapter = adapter3
                }

                list3.apply {
                    add(Model1("Home Services"))
                    add(Model1("Health & Fitness"))
                    add(Model1("Beauty & Spas"))
                    add(Model1("Personal Services"))
                    add(Model1("Things To Do"))
                    add(Model1("Automotive"))
                    add(Model1("Retail"))
                    add(Model1("Food & Drink"))
                }
                adapter3.setList3(list3)

                if (!model1.expanded) {
                    expandable2.visibility = View.VISIBLE
                    image2.animate().rotation(180F).start()
                    model1.expanded = true
                } else {
                    expandable2.visibility = View.GONE
                    image2.animate().rotation(360F).start()
                    model1.expanded = false
                }
            }
        }
    }
}
package com.example.expandablerecyclerview.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerview.Model.Model1
import com.example.expandablerecyclerview.R
import kotlinx.android.synthetic.main.list_item2.view.*
import kotlinx.android.synthetic.main.list_item3.view.*
import kotlinx.android.synthetic.main.recyclerview3.view.*

class MyAdapter3 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var modelList3: List<Model1> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder2(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item3, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return modelList3.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MyViewHolder2 -> {
                holder.bind(modelList3[position])
            }
        }
    }

    fun setList3(list: List<Model1>) {
        modelList3 = list
    }

    class MyViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text2 = itemView.textview3
//        val recyclerView3 = itemView.recyclerview3
//        lateinit var adapter3: MyAdapter3
//        val list3 = ArrayList<Model1>()

        fun bind(model1: Model1) {
            text2.text = model1.name
//            recyclerView3.apply {
//                layoutManager = LinearLayoutManager(
//                    itemView.context,
//                    LinearLayoutManager.VERTICAL, false
//                )
//                adapter3 = MyAdapter3()
//                adapter = adapter3
//            }

//            list3.apply {
//                add(Model1("Home Services"))
//                add(Model1("Health & Fitness"))
//                add(Model1("Beauty & Spas"))
//                add(Model1("Personal Services"))
//                add(Model1("Things To Do"))
//                add(Model1("Automotive"))
//                add(Model1("Retail"))
//                add(Model1("Food & Drink"))
//            }
//            adapter3.setList3(list3)

        }
    }
}
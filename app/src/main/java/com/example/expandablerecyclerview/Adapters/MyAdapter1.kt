package com.example.expandablerecyclerview.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerview.Model.Model1
import com.example.expandablerecyclerview.R
import kotlinx.android.synthetic.main.list_item1.view.*
import kotlinx.android.synthetic.main.list_item2.view.*
import kotlinx.android.synthetic.main.recyclerview2.view.*

class MyAdapter1 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var modelList: List<Model1> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item1, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is MyViewHolder -> {
                holder.bind(modelList[position])

//                if (holder.previousPosition == -1 && holder.currentPosition == -1) {
//                    holder.previousPosition = holder.adapterPosition
//                    holder.currentPosition = holder.adapterPosition
////                    expandableLayout.get(previousPosition).visibility = View.GONE
//                }else {
//                    holder.previousPosition = holder.currentPosition
//                    holder.currentPosition = holder.adapterPosition
//                }
//
//                holder.expandableLayout.get(holder.previousPosition).visibility = View.GONE
//                holder.expandableLayout.get(holder.currentPosition).visibility = View.VISIBLE


            }
        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    fun setList1(list: List<Model1>) {
        modelList = list
    }

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val text1 = itemview.textview
        val expandableLayout = itemview.expandable1
        val recyclerView2 = itemView.recyclerview2
        lateinit var adapter2: MyAdapter2
        val image1 = itemview.image1
        var previousPosition : Int = -1
        var currentPosition : Int = -1

        val list2 = ArrayList<Model1>()
        val list4 = ArrayList<Model1>()
        val list5 = ArrayList<Model1>()
        val list6 = ArrayList<Model1>()

        fun bind(model1: Model1) {
            text1.text = model1.name
            image1.setOnClickListener {

//                if (previousPosition != -1 && previousPosition != adapterPosition) {
//                    expandableLayout.get(previousPosition).visibility = View.GONE
//                }

                /*if (previousPosition == -1 && currentPosition == -1) {
                    previousPosition = adapterPosition
                    currentPosition = adapterPosition
//                    expandableLayout.get(previousPosition).visibility = View.GONE
                }else if (previousPosition != -1 && currentPosition != -1){
                    previousPosition = currentPosition
                    currentPosition = adapterPosition
                }

                expandableLayout.get(previousPosition).visibility = View.GONE
                expandableLayout.get(currentPosition).visibility = View.VISIBLE*/

                recyclerView2.apply {
                    layoutManager = LinearLayoutManager(itemView.context)
                    adapter2 = MyAdapter2()
                    adapter = adapter2
                }
                list2.clear()
                list2.apply {
                    add(Model1("HVAC & Electrical"))
                    add(Model1("Contractors"))
                    add(Model1("Lawn & Garden"))
                    add(Model1("Home Repairs"))
                    add(Model1("Remodeling"))
                    add(Model1("Flooring"))
                    add(Model1("Cleaning Services"))
                    add(Model1("Plumbing"))
                }
                list4.clear()
                list4.apply {
                    add(Model1("Weight Loss"))
                    add(Model1("Vision"))
                    add(Model1("Gyms"))
                    add(Model1("Dental"))
                    add(Model1("Sports"))
                    add(Model1("Medical"))
                    add(Model1("Fitness Classes"))
                    add(Model1("Natural Medicine"))
                }
                list5.clear()
                list5.apply {
                    add(Model1("Face & Skin Care"))
                    add(Model1("Makeup"))
                    add(Model1("Massage"))
                    add(Model1("Bros & Lashes"))
                    add(Model1("Nail Salons"))
                    add(Model1("Cosmetic Procedures"))
                    add(Model1("Blowouts & Styling"))
                    add(Model1("Salons"))
                }
                list6.clear()
                list6.apply {
                    add(Model1("Event Rental Services"))
                    add(Model1("Pets"))
                    add(Model1("Photography"))
                    add(Model1("Local Services"))
                    add(Model1("Classes"))
                    add(Model1("Consultants"))
                    add(Model1("Electronics Repair"))
                    add(Model1("Food & Drink"))
                }

                if (model1.name.equals("Home Services",true)){
                    adapter2.setList2(list2)
                }else if (model1.name.equals("Health & Fitness",true)){
                    adapter2.setList2(list4)
                }else if (model1.name.equals("Beauty & Spas",true)){
                    adapter2.setList2(list5)
                }else if (model1.name.equals("Personal Services",true)){
                    adapter2.setList2(list6)
                }

                if (!model1.expanded) {
                    Toast.makeText(itemView.context,"Working",Toast.LENGTH_SHORT).show()
                    expandableLayout.visibility = View.VISIBLE
                    image1.animate().rotation(180F).start()
                    model1.expanded = true
                } else {
                    Toast.makeText(itemView.context,"Not Working",Toast.LENGTH_SHORT).show()
                    expandableLayout.visibility = View.GONE
                    image1.animate().rotation(360F).start()
                    model1.expanded = false
                }
            }
        }
    }
}
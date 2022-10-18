package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(var list : ArrayList<Food>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var name = holder.itemView.findViewById<TextView>(R.id.name)
        name.text = list.get(position).name
        var image = holder.itemView.findViewById<ImageView>(R.id.image)
        image.setImageResource(list.get(position).image)
    }

    override fun getItemCount(): Int {
        return list.size;
    }
}
package com.example.newapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(var productsList: List<Result>,
                val sortedProducts: List<Result> = productsList.sortedWith(compareByDescending { it.price })):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {

        var img:ImageView = view.findViewById(R.id.prodImage)
        var prodName: TextView = view.findViewById(R.id.prodName)
        var price : TextView = view.findViewById(R.id.price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return ViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return sortedProducts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var productData = sortedProducts[position]
        holder.img.setImage(productData.image)
        holder.prodName.text = productData.title
        holder.price.text= productData.price.toString() + "$"

    }
}
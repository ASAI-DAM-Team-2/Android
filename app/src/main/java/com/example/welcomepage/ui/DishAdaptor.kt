package com.example.welcomepage.ui

import ApixuApiService
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.welcomepage.R
import com.example.welcomepage.data.DishesResponseItem

class DishAdaptor: RecyclerView.Adapter<DishViewHolder>() {
    val apiService = ApixuApiService()
    var data = arrayOf(apiService.getDishes())
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.toString()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.fragment_dishes, parent, false) as TextView

        return DishViewHolder(view)
    }

}
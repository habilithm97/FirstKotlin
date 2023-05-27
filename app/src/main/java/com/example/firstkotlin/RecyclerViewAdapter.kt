package com.example.firstkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotlin.databinding.ItemRecyclerviewBinding

class RecyclerViewHolder(val binding: ItemRecyclerviewBinding):
    RecyclerView.ViewHolder(binding.root)

class RecyclerViewAdapter(val items: MutableList<String>?):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemCount(): Int {
        return items?.size ?: 0 // 널 안전성 호출, items의 크기가 null이면 0 리턴
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = RecyclerViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as RecyclerViewHolder).binding
        binding.tv.text= items!![position]
    }
}

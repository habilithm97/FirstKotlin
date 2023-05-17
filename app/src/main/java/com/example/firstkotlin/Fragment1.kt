package com.example.firstkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotlin.databinding.Fragment1Binding
import com.example.firstkotlin.databinding.ItemMainBinding

class ViewHolder(val binding : ItemMainBinding) :
    RecyclerView.ViewHolder(binding.root)

class ItemAdapter(val items : MutableList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder =
        ViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ViewHolder).binding
        binding.tv.text = items[position]
    }

}
class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Fragment1Binding.inflate(inflater, container, false)

        val items = mutableListOf<String>()
        for(i in 1..20) {
            items.add("$i 번째 아이템")
        }

        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager

        val adapter = ItemAdapter(items)
        binding.recyclerView.adapter = adapter

        return binding.root
    }
}
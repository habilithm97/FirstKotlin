package com.example.firstkotlin

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
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
        binding.recyclerView.addItemDecoration(ItemDecoration(activity as Context))

        return binding.root
    }

    class ItemDecoration(val context: Context) : RecyclerView.ItemDecoration() {
        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDrawOver(c, parent, state)

            // 뷰 크기 계산
            val width = parent.width
            val height = parent.height

            // 이미지 크기 계산
            val drawable: Drawable? = ResourcesCompat.getDrawable(context.getResources(),
                R.drawable.kbo, null)
            val drWidth = drawable?.intrinsicWidth
            val drHeight = drawable?.intrinsicHeight

            // 이미지를 출력할 위치 계산
            val left = width/2 - drWidth?.div(2) as Int
            val top = height/2 - drHeight?.div(2) as Int

            // 이미지 출력
            c.drawBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.kbo),
                left.toFloat(),
                top.toFloat(),
                null
            )
        }
    }
}
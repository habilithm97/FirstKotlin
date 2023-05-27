package com.example.firstkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstkotlin.databinding.ActivityTodoListTestBinding

class TodoListTest : AppCompatActivity() {
    lateinit var binding : ActivityTodoListTestBinding
    var items : MutableList<String>? = null
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        adapter = RecyclerViewAdapter(items)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { // 인텐트 처리자
            // 사후 처리
            it.data!!.getStringExtra("str")?.let {
                items?.add(it)
                adapter.notifyDataSetChanged()
            }
        }

        binding.floatingBtn.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }

        items = savedInstanceState?.let { // 매개변수로 넘어온 번들 객체가 null이 아니면
            it.getStringArrayList("items")?.toMutableList()
        } ?: let { // null이면
            mutableListOf<String>() // 초기화
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("items", ArrayList(items))
    }
}
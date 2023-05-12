package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstkotlin.databinding.ActivityResTestBinding

class ResTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityResTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
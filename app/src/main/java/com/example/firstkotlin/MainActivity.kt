package com.example.firstkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val intent = Intent(this, StopWatchTest::class.java)
            startActivity(intent)
        }

        binding.btn1.setOnClickListener {
            val intent = Intent(this, ResTest::class.java)
            startActivity(intent)
        }

        binding.btn2.setOnClickListener {
            val intent = Intent(this, JetpackMaterialTest::class.java)
            startActivity(intent)
        }
    }
}
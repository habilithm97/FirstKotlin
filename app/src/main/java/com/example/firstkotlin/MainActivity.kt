package com.example.firstkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstkotlin.activity.ActivityTest
import com.example.firstkotlin.brodcastreceiver.ReceiverTest
import com.example.firstkotlin.databinding.ActivityMainBinding
import com.example.firstkotlin.event.EventTest
import com.example.firstkotlin.jetpackmaterial.JetpackMaterialTest
import com.example.firstkotlin.res.ResTest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val intent = Intent(this, EventTest::class.java)
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

        binding.btn3.setOnClickListener {
            val intent = Intent(this, ActivityTest::class.java)
            startActivity(intent)
        }

        binding.btn4.setOnClickListener {
            val intent = Intent(this, ReceiverTest::class.java)
            startActivity(intent)
        }
    }
}
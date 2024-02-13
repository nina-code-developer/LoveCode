package com.example.mylanguagelove

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylanguagelove.databinding.ActivityMainBinding
import com.example.mylanguagelove.UI.PromesaActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPresioname.setOnClickListener {
            val intent = Intent(this@MainActivity, PromesaActivity::class.java)


            startActivity(intent)
        }

    }
}
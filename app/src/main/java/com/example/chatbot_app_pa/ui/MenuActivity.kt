package com.example.chatbot_app_pa.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.chatbot_app_pa.R
import com.example.chatbot_app_pa.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val button = findViewById<ConstraintLayout>(R.id.chatbot_menu)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
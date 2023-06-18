package com.konsulpintarv0.chatbot_app_pa.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.konsulpintarv0.chatbot_app_pa.R
import com.konsulpintarv0.chatbot_app_pa.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val button = findViewById<Button>(R.id.welcome_button)
        button.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

    }
}
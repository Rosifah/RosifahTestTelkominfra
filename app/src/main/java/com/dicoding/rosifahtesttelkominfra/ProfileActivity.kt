package com.dicoding.rosifahtesttelkominfra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ImageButton


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backButton = findViewById<ImageButton>(R.id.backhome)
        backButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
    fun backToMain(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    fun backToMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
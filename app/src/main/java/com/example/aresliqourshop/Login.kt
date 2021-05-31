package com.example.aresliqourshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn = findViewById<Button>(R.id.btnLogin)
        val signBtn = findViewById<TextView>(R.id.tvLogin)

        loginBtn.setOnClickListener {
            val intent = Intent(this, DAshbord::class.java)
            startActivity(intent)
        }

        signBtn.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }


    }
}
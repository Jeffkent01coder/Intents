package com.example.aresliqourshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aresliqourshop.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding?.btnLogin?.setOnClickListener {
            val inputs = arrayOf(binding?.usernameLogin, binding?.passwordLogin)
            var filled = true
            inputs.forEach { input ->
                filled = filled && input!!.text!!.isNotEmpty()
                if (!filled){
                    input?.error = "required"
                }
            }.also {
                if (filled){
                    // Authenticate with firebase later
                    startActivity(Intent(this, DAshbord::class.java))
                }
            }
        }

        binding?.tvLogin?.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }
}
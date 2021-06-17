package com.example.aresliqourshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val signInBtn = findViewById<TextView>(R.id.alreadyHaveAcc)
        val registerBtn = findViewById<Button>(R.id.btnRegister)
        val usernameLogin = findViewById<EditText>(R.id.usernameLogin)
        val passwordLogin = findViewById<EditText>(R.id.passwordLogin)
        val inputNumber = findViewById<EditText>(R.id.inputNumber)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)
        val inputConfirmPass = findViewById<EditText>(R.id.inputConfirmPass)

        signInBtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        registerBtn.setOnClickListener {

            when {
                TextUtils.isEmpty(usernameLogin.text.toString()) -> {
                    usernameLogin.error = "Please enter username"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(passwordLogin.text.toString()) -> {
                    passwordLogin.error = "Please enter Email"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(inputNumber.text.toString()) -> {
                    inputNumber.error = "Please enter Phone number"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(inputPassword.text.toString()) -> {
                    inputPassword.error = "Please enter password"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(inputConfirmPass.text.toString()) -> {
                    inputConfirmPass.error = "Please enter confirm password"
                    return@setOnClickListener
                }
                inputPassword.text.toString()!= inputConfirmPass.text.toString() -> {
                    inputConfirmPass.error = "passwords do not match"
                    return@setOnClickListener
                }
                else -> {
                    auth.createUserWithEmailAndPassword(
                        passwordLogin.text.toString(),
                        inputPassword.text.toString()
                    )
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                val currentuser = auth.currentUser
                            }
                        }

                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
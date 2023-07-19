package com.example.billsapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billsapp.databinding.ActivityMain2Binding
import com.example.billsapp.viewmodels.Home


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSignIn.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            validateSignup()
        }
        validateSignup()
        clearErrors()
    }

    fun validateSignup() {

        val email = binding.tilemail.text.toString()
        val password = binding.tilPassWord.text.toString()
        var error = false


        if (email.isBlank()) {
            binding.tilPassWord.error = "Enter your email"
            error = true
        }

        if (password.isBlank()) {
            binding.tilPassWord.error = "enter your password"
            error = true
        }


    }

    fun clearErrors() {
        binding.tilemail.error = null
        binding.tilPassWord.error = null
    }
}
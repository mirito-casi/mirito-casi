package com.example.todofibraoptc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todofibraoptc.databinding.ActivityLoginBinding
import com.example.todofibraoptc.databinding.ActivityRegistroUserBinding

class  RegistroUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}
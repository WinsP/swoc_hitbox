package com.development.hybrid.project.views.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.development.hybrid.project.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
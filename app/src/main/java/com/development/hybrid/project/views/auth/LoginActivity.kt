package com.development.hybrid.project.views.auth

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.development.hybrid.project.R
import com.development.hybrid.project.databinding.ActivityLoginBinding
import com.development.hybrid.project.views.main.HomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonActionLogin.setOnClickListener {
            if (onValidateValues()){
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                val dialog = ProgressDialog(this@LoginActivity)
                dialog.isIndeterminate = true
                dialog.show()
                Thread.sleep(2000)
                dialog.dismiss()
                finish()
            }
        }

    }

    private fun onValidateValues() : Boolean{
        when {
            TextUtils.isEmpty(binding.textInputEditTextPersonUserName.text.toString().trim()) -> {
                binding.textInputLayoutPersonUserName.error = getString(R.string.text_value_null_error)
                return false
            }
            binding.textInputEditTextPersonUserName.text.toString().trim() != "android2021" -> {
                binding.textInputLayoutPersonUserName.error = getString(R.string.text_value_user_name_error)
                return false
            }
            else -> {
                binding.textInputLayoutPersonUserName.isErrorEnabled = false
            }
        }
        when {
            TextUtils.isEmpty(binding.textInputEditTextPersonPassword.text.toString().trim()) -> {
                binding.textInputLayoutPersonPassword.error = getString(R.string.text_value_null_error)
                return false
            }
            binding.textInputEditTextPersonPassword.text.toString().trim() != "Example123" -> {
                binding.textInputLayoutPersonPassword.error = getString(R.string.text_value_password_error)
                return false
            }
            else -> {
                binding.textInputLayoutPersonPassword.isErrorEnabled = false
            }
        }
        return true
    }

}
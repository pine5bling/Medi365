package com.thomnt.medi365.presentation.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thomnt.medi365.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}

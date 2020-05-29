package com.example.welcomepage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.welcomepage.R
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        loginButton.setOnClickListener{
            val intentGoToWelcomePage = Intent(this, MainActivity::class.java)
            startActivity(intentGoToWelcomePage)
        }
    }
}

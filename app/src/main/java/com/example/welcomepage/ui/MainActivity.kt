package com.example.welcomepage.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.welcomepage.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener{
            val intentGoToWelcomePage = Intent(this, WelcomePage::class.java)
            startActivity(intentGoToWelcomePage)
        }

        registerButton.setOnClickListener{
            val intentGoToRegisterPage = Intent(this, RegisterActivity::class.java)
            startActivity(intentGoToRegisterPage)
        }


    }
}

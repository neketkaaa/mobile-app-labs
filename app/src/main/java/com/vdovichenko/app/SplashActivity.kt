package com.vdovichenko.app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vdovichenko.app.ContentActivity

class SplashActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //val LoginIntent= Intent(this, LoginActivity::class.java)
        //val RegistrationIntent= Intent(this, RegistrationActivity::class.java)
        val sharedPreferences=getSharedPreferences("setting", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("data") && sharedPreferences.contains("password"))
        {   if(sharedPreferences.contains("checkbox"))
        {
            val ContentIntent= Intent(this, ContentActivity::class.java)
            startActivity(ContentIntent)
        }
        else
        {
            val LoginIntent= Intent(this, LoginActivity::class.java)
            startActivity(LoginIntent)
        }
        }
        else
        {
            val RegistrationIntent= Intent(this, RegistrationActivity::class.java)
            startActivity(RegistrationIntent)
        }
    }
}
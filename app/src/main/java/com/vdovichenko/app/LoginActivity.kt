package com.vdovichenko.app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPreferences=getSharedPreferences("setting", Context.MODE_PRIVATE);
        val Data=sharedPreferences.getString("data","default")
        val Password=sharedPreferences.getString("password","default")
        val buttonLogin=findViewById<Button>(R.id.login_button)
        val Checkbox=findViewById<CheckBox>(R.id.check)
        val Phoneemail=findViewById<EditText>(R.id.data)
        val password=findViewById<EditText>(R.id.password)
        buttonLogin.setOnClickListener{
            val PhoneemailC=Phoneemail.text.toString()
            val PasswordC=password.text.toString()
            if(Data==PhoneemailC && PasswordC==Password)
            {
                val intentContent= Intent(this,ContentActivity::class.java)
                startActivity(intentContent)
                if(Checkbox.isChecked()==true)
                {
                    sharedPreferences.edit().putString("checkbox","yes").apply()
                }
            }
            else
            {
                val toast = Toast.makeText(this@LoginActivity, "FROM USER "+PhoneemailC+PasswordC+"FROM DATA     "+Data+Password, Toast.LENGTH_LONG)
                toast.show();
            }

        }
    }
}
package com.vdovichenko.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vdovichenko.app.ContentActivity

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val Enterbutton=findViewById<Button>(R.id.registry_button)
        val Phoneemail=findViewById<EditText>(R.id.emailtext)
        val password=findViewById<EditText>(R.id.password)
        val passwordC=findViewById<EditText>(R.id.password_confirm)
        val buttonEmail=findViewById<Button>(R.id.email_button)
        val buttonPhone=findViewById<Button>(R.id.phone_button)
        var isEnterMethodEmail=true
        val sharedPreferences=getSharedPreferences("setting", Context.MODE_PRIVATE);
        buttonEmail.setOnClickListener{
            Phoneemail.hint="Введите email"
            isEnterMethodEmail=true
            buttonPhone.alpha= 0.1F
            buttonEmail.alpha= 0.25F
        }
        buttonPhone.setOnClickListener{
            Phoneemail.hint="Введите номер"
            isEnterMethodEmail=false
            buttonEmail.alpha= 0.1F
            buttonPhone.alpha= 0.25F
        }
        Enterbutton.setOnClickListener{
            val passwordLength=password.text.toString().length
            val content=Phoneemail.text.toString()
            val doesHaveAt=content.contains("@")
            val doesHavePlus=content.contains("+")
            var isRight=false
            if (isEnterMethodEmail==true && content.contains("@"))
            {
                isRight=true
            }
            else if (isEnterMethodEmail==false && content.contains("+"))
            {
                isRight=true
            }

            val equals=(password.text.toString()==passwordC.text.toString())
            //val how=isEnterMethodEmail.toString()
            if ( isRight && equals && (passwordLength>=8))
            {
                val toast = Toast.makeText(this@RegistrationActivity, "GOOD" , Toast.LENGTH_LONG)
                toast.show();
                sharedPreferences.edit().putString("data",Phoneemail.text.toString()).apply()
                sharedPreferences.edit().putString("password",password.text.toString()).apply()
                val intentContent= Intent(this, ContentActivity::class.java)
                startActivity(intentContent)
            }else
            {
                val toast = Toast.makeText(this@RegistrationActivity, "BAD", Toast.LENGTH_LONG)
                toast.show();
            }

        }

    }
}
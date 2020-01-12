package com.example.esewa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val handler = Database(this)
        login.setOnClickListener {
            if(username.text.toString().isEmpty() || password.text.toString().isEmpty()){
                Toast.makeText(this,"All fields are required",Toast.LENGTH_LONG).show()
            }
            else{
                if(handler.login(username.text.toString(),password.text.toString())){
                    Toast.makeText(this,"Logged in successfully",Toast.LENGTH_LONG).show()
                } else{
                    Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}

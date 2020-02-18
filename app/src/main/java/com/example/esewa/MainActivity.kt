package com.example.esewa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher

import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            val handler = Database(this)

            emailR.addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(s: Editable?) {

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emailR.text.toString()).matches()){
                        Toast.makeText(this@MainActivity, "Enter valid email", Toast.LENGTH_LONG)
                            .show()                    }
                }

            })

            RegisterR.setOnClickListener {
                if (usernameR.text.toString().isEmpty() || passwordR.text.toString().isEmpty()) {
                    Toast.makeText(
                        this,
                        "All fields are required",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
                else{

                    if(handler.insertData(usernameR.text.toString(),emailR.text.toString(),passwordR.text.toString())){
                        Toast.makeText(this,"User Inserted Successfully",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,Login::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show()
                    }
                }
            }


        LoginR.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }






    }
}

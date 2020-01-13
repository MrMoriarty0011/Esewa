package com.example.esewa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_daily.*


class DailyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)

        val approaches=arrayOf("--Select--","Email","Phone","Meeting")
        val ArrayAdp = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,approaches)
        approach.adapter = ArrayAdp



        val client=arrayOf("Swastik College","Bridge Water COllege","LoardBuddha","Simple College","Hetauda College","Dadhikot","","","","","","","","","","")
        val arrayAdapterForClient=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,client)
        auto.setAdapter(arrayAdapterForClient)



        val activities=arrayOf("--Select--","Appointment","API","Operation","Documents","New Approach","Follow Up","Agrement Signed","Payment Received")
        val ArrayAdpt = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,activities)
        activity.adapter = ArrayAdpt


        marquee.setOnClickListener {
            marquee.text="Daily report of esewa fone pay private limited"
            marquee.setSingleLine()
            marquee.ellipsize= TextUtils.TruncateAt.MARQUEE
            marquee.marqueeRepeatLimit = -1//-1 ->for infinite effects and 1->for finite effect
            marquee.isSelected=true
        }

        submit.setOnClickListener {
            if (name.text.toString().isEmpty() || date.text.toString().isEmpty() || auto.text.toString().isEmpty() || activity.isEmpty() || approach.isEmpty() || participant.text.toString().isEmpty() || remarks.text.toString().isEmpty()){
                Toast.makeText(this,"All fields are required",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Data submitted successfully",Toast.LENGTH_LONG).show()
            }




        }


    }
}
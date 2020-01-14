package com.example.esewa

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_daily.*


class DailyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)

        val handler3 = DailyDatabase(this)

        val app = findViewById<Spinner>(R.id.approach)
        val approaches=arrayOf("--Select--","Email","Phone","Meeting")
        val ArrayAdp = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,approaches)
        app.adapter = ArrayAdp
        val a = app.getSelectedItem().toString()


        var cardStatusString: String = ""
        activity.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?, pos: Int, id: Long
            ) {
                cardStatusString = parent.getItemAtPosition(pos).toString()
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        })

        var cardStatusString1: String = ""
        approach.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?, pos: Int, id: Long
            ) {
                cardStatusString1 = parent.getItemAtPosition(pos).toString()
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        })




        val client=arrayOf("Swastik College","Bridge Water College","LoardBuddha","Simple College","Hetauda College","Dadhikot")
        val arrayAdapterForClient=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,client)
        auto.setAdapter(arrayAdapterForClient)




        val act = findViewById<Spinner>(R.id.activity)
        val activities=arrayOf("--Select--","Appointment","API","Operation","Documents","New Approach","Follow Up","Agrement Signed","Payment Received")
        val ArrayAdpt = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,activities)
        act.adapter = ArrayAdpt
        val b = act.getSelectedItem().toString()



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
                if(handler3.insertData(name.text.toString(),date.text.toString(),auto.text,cardStatusString,cardStatusString1 ,participant.text.toString(),remarks.text.toString())){
                    Toast.makeText(this,"Data submitted successfully",Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,DisplayActivity::class.java))
                }
                else{
                    Toast.makeText(this,"Data submition failed",Toast.LENGTH_LONG).show()
                }
            }




        }


    }
}
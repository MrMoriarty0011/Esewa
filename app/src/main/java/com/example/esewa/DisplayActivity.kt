package com.example.esewa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_daily.*
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val handler = DailyDatabase(this)



        val dail = handler.GetUsers()

        if (dail != null) {
            for (key in dail){
                texts.append("Activity Name = ${key.get("ActivityName")} \n" +
                        "Date = ${key.get("Date")}\n" +
                        "Client=${key.get("Client")}\n " +
                        "Activity=${key.get("Activity")}\n" +
                        "Approach=${key.get("Approach")}\n" +
                        "Participant=${key.get("Participant")}\n" +
                        "Remarks=${key.get("Remarks")} \n\n"
                )
            }


        }
    }
}

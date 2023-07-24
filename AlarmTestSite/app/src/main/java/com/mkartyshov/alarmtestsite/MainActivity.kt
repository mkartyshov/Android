package com.mkartyshov.alarmtestsite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buSetTime(view: View) {
        val setTime = SetTime()
        val fm = supportFragmentManager
        setTime.show(fm, "Select Time")

    }

    fun setTime(hours: Int, minutes: Int) {
        val time = findViewById<TextView>(R.id.time)
        if (minutes < 10) {
            time.text = "$hours:0$minutes"
        } else {
            time.text = "$hours:$minutes"
        }

        val saveData = SaveData(applicationContext)
        saveData.setAlarm(hours, minutes)

    }
}
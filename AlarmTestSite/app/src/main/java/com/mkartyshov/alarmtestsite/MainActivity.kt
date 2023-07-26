package com.mkartyshov.alarmtestsite

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

    fun setTime(hours: Int, minutes: Int, weekday: Int) {
        val time = findViewById<TextView>(R.id.time)
        if (minutes < 10) {
            time.text = "$hours:0$minutes"
        } else {
            time.text = "$hours:$minutes"
        }

        val saveData = SaveData(applicationContext)
        saveData.saveData(hours, minutes, weekday)
        saveData.setAlarm()

        val day = findViewById<TextView>(R.id.day)
        when (weekday) {
            1 -> day.text = "Sunday"
            2 -> day.text = "Monday"
            3 -> day.text = "Tuesday"
            4 -> day.text = "Wednesday"
            5 -> day.text = "Thursday"
            6 -> day.text = "Friday"
            7 -> day.text = "Saturday"
        }
    }
}
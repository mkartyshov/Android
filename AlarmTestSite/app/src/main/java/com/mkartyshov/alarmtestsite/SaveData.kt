package com.mkartyshov.alarmtestsite

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Calendar

class SaveData(context: Context) {
    private var context: Context ?= null
    private var sharedPref: SharedPreferences ?= null
    init {
        this.context = context
        sharedPref = context.getSharedPreferences("mypref", Context.MODE_PRIVATE)
    }

    fun saveData(hours: Int, minutes: Int, weekday: Int) {
        val editor = sharedPref!!.edit()
        editor.putInt("hours", hours)
        editor.putInt("minutes", minutes)
        editor.putInt("weekday", weekday)
        editor.apply()
    }

    private fun getHours() = sharedPref!!.getInt("hours", 0)

    private fun getMinutes() = sharedPref!!.getInt("minutes", 0)

    private fun getWeekday() = sharedPref!!.getInt("weekday", 0)

    fun setAlarm() {
        val calendar = Calendar.getInstance()
        val hours = getHours()
        val minutes = getMinutes()
        val weekday = getWeekday()

        calendar.set(Calendar.DAY_OF_WEEK, weekday)
        calendar.set(Calendar.HOUR_OF_DAY, hours)
        calendar.set(Calendar.MINUTE, minutes)
        calendar.set(Calendar.SECOND, 0)

        val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(context, BroadcastReceiver::class.java)
        intent.putExtra("message", "alarm time")
        intent.action = "com.tester.alarmmanager"

        val pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_MUTABLE)

        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pi)

    }

}
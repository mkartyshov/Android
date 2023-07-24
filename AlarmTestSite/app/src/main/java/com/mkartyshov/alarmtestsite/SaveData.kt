package com.mkartyshov.alarmtestsite

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Calendar

class SaveData(context: Context) {
    var context: Context ?= null
    var sharedPref: SharedPreferences ?= null
    init {
        this.context = context
        sharedPref = context.getSharedPreferences("mypref", Context.MODE_PRIVATE)
    }

    fun setAlarm(hours: Int, minutes: Int) {
        val calendar = Calendar.getInstance()

        calendar.set(Calendar.HOUR_OF_DAY, hours)
        calendar.set(Calendar.MINUTE, minutes)
        calendar.set(Calendar.SECOND, 0)

        val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        var intent = Intent(context, BroadcastReceiver::class.java)
        intent.putExtra("message", "alarm time")
        intent.action = "com.tester.alarmmanager"

        val pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_MUTABLE)

        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pi)

    }

}
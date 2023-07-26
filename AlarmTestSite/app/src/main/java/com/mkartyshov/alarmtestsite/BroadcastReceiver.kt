package com.mkartyshov.alarmtestsite

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

class BroadcastReceiver: BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        
        if (intent!!.action == "com.tester.alarmmanager") {
            val b = intent.extras
            Toast.makeText(context, b!!.getString("message"), Toast.LENGTH_LONG).show()
            val i = Intent(context, MusicService::class.java)
            context!!.applicationContext.startForegroundService(i)
        } else if (intent.action.equals("android.intent.action.BOOT_COMPLETED")) {
            val saveData = SaveData(context!!)
            saveData.setAlarm()
        }
    }
}
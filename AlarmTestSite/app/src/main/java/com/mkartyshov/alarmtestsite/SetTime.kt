package com.mkartyshov.alarmtestsite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText

class SetTime: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.set_time, container, false)
        val buttonDone = myView.findViewById(R.id.button_done) as Button
        val timePicker = myView.findViewById(R.id.time_picker) as TimePicker
        val dayPicker = myView.findViewById(R.id.day_picker) as TextInputEditText

        buttonDone.setOnClickListener {
            val ma = activity as MainActivity
            ma.setTime(timePicker.hour, timePicker.minute, dayPicker.text.toString().toInt())
            this.dismiss()
        }

        return myView
    }
}
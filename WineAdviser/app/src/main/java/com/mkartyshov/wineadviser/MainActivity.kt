package com.mkartyshov.wineadviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findWine = findViewById<Button>(R.id.button)
        val dishes = findViewById<Spinner>(R.id.dishes)
        val wineName = findViewById<TextView>(R.id.textView)
        
        findWine.setOnClickListener {
            when (dishes.selectedItem.toString()) {
                "Meat" -> wineName.text = getString(R.string.red)
                "Fish" -> wineName.text = getString(R.string.white)
                "Salad" -> wineName.text = getString(R.string.rose)
            }
        }
    }
}
package com.gamzecoskun.datepicker

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Locale


private lateinit var textDate:TextView
private lateinit var btnDate:Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textDate=findViewById(R.id.textDate)
        btnDate=findViewById(R.id.btnDate)

        val calendarBox= Calendar.getInstance()
        val dateBox=DatePickerDialog.OnDateSetListener{datePicker,year,month,day ->
            calendarBox.set(Calendar.YEAR,year)
            calendarBox.set(Calendar.MONTH,month)
            calendarBox.set(Calendar.DAY_OF_MONTH,day)

            updateText(calendarBox)
        }
         btnDate.setOnClickListener{
             DatePickerDialog(this,dateBox,calendarBox.get(Calendar.YEAR),calendarBox.get(Calendar.MONTH),calendarBox.get(Calendar.DAY_OF_MONTH)).show()
         }
    }

    private fun updateText(calendar:Calendar){
        val dateFormat="dd-MM-yyyy"
        val simple=SimpleDateFormat(dateFormat, Locale.UK)
        textDate.setText(simple.format(calendar.time))
    }
}
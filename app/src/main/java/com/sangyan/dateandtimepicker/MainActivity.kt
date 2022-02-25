package com.sangyan.dateandtimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.text.format.DateFormat.is24HourFormat
import android.widget.DatePicker
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*

import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() , TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    var day = 0
    var month : Int  =0
    var year : Int= 0
    var hour :Int = 0
    var minute = 0
    var myDay = 0
    var myMonth : Int = 0
    var myYear : Int = 0
    var myHour = 0
    var myMinute =0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPick.setOnClickListener{
            val calendar: Calendar = Calendar.getInstance()
      hour = calendar.get(Calendar.HOUR)
       minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this@MainActivity, this@MainActivity, hour, minute,
                DateFormat.is24HourFormat(this))
            timePickerDialog.show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this@MainActivity, this@MainActivity, hour, minute,
            DateFormat.is24HourFormat(this))
        timePickerDialog.show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay : Int, p2: Int) {
      myHour = hourOfDay
        myMinute = minute
      textView.text = "Hour : $myHour\nMinute : $myMinute\n"

    }
}
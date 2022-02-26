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
import java.time.Month

import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() , TimePickerDialog.OnTimeSetListener , DatePickerDialog .OnDateSetListener{
    var hours = 0
    var minutes = 0
    var day = 0
    var month = 0
    var year = 0
    var myHours : Int = 0
    var myMinutes : Int= 0
    var myDay : Int = 0
    var myMonth  :Int = 0
    var myYear :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener{
            val calender = Calendar.getInstance()
            day = calender.get(Calendar.DAY_OF_MONTH)
            month = calender.get(Calendar.MONTH)
            year = calender.get(Calendar.YEAR)
            var datePickerDialog = DatePickerDialog(this,this,day,month,year)
            datePickerDialog.show()

        }


    }

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        myHours = hour
        myMinutes = minute
        showTime.text = "Day:" + myDay + "\n"
                "Month:"+ myMonth + "\n"
                "Year:"+ myYear+ "\n"
                "Hours: " + myHours + "\n" +
                        "Minutes:" +  myMinutes + "\n"

    }

    override fun onDateSet(vire: DatePicker?, year: Int, month: Int, dayofMonth: Int) {
         myDay = dayofMonth
        myMonth = month
        myYear = year
        val calendar = Calendar.getInstance()
        hours = calendar.get(Calendar.HOUR)
        minutes = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this,this,hours,minutes,true)
        timePickerDialog.show()

    }

}

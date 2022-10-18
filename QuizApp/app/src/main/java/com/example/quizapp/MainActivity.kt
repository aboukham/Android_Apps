package com.example.quizapp

import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.submit)
        val box1 = findViewById<CheckBox>(R.id.button21)
        val box2 = findViewById<CheckBox>(R.id.button22)
        val box3 = findViewById<CheckBox>(R.id.button23)
        btn1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Quiz Result")
            val localDate: LocalDateTime = LocalDateTime.now()
            val dtFormatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd hh:mm:ss")
            val date = dtFormatter.format(localDate)
            var result = 0
            var radio1 = findViewById<RadioButton>(R.id.button13).isChecked
            if (radio1)
                result += 50
            if (box1.isChecked && box3.isChecked)
                result += 50
            if (result == 50) {
                builder.setMessage("Congratulations! You submitted on $date , Your achieved 50%")
                builder.setIcon(R.drawable.success)
            }
            else if (result == 100) {
                builder.setMessage("Congratulations! You submitted on $date , Your achieved 100%")
                builder.setIcon(R.drawable.success)
            }
            else{
                builder.setMessage("Unfortunately! You submitted on $date , but your achieved 0%, please try again")
                builder.setIcon(R.drawable.failed)
            }
            builder.setPositiveButton("ok"){dialogInterface, which ->
                dialogInterface.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }
        val btn2 = findViewById<Button>(R.id.reset)
        btn2.setOnClickListener {
            val radio = findViewById<RadioGroup>(R.id.group)
            radio.clearCheck()
            box1.isChecked = false
            box2.isChecked = false
            box3.isChecked = false
        }
    }
}
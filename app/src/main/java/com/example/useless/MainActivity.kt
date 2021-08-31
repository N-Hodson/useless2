package com.example.useless

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

//switch useless
// self destruct button
//look busy button
//chain useless & destruct button  verticalley,center horizantaly


class MainActivity : AppCompatActivity() {

    lateinit var useless: Switch
    lateinit var destruct: Button
    lateinit var busy: Button
    lateinit var layout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wireWidgets()

        useless.setOnCheckedChangeListener { buttonView, ischecked ->
            if (!ischecked) {
                Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show()
                startSwitchTimer()
                useless.isClickable = false

            }
        }
    }

    private fun sefDestruct() {
        destruct.setOnClickListener {
            var timesChanged = 0
            if (timesChanged > 10) {
                timesChanged = 0
                finish()
            } else {
                timesChanged++
                startDestruct1()
                layout.setBackgroundColor(Color.argb(255, 255, 255, 255))
            }
        }
    }
    private fun wireWidgets() {
        useless = findViewById(R.id.switch_main_useless)
        destruct = findViewById(R.id.button_main_destruct)
        busy = findViewById(R.id.button_main_busy)
        layout = findViewById(R.id.layout)
    }

    private fun startSwitchTimer() {
        val uselessTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                useless.isClickable = true
                useless.isChecked = false
            }
        }
        uselessTimer.start()

    }
    private fun startDestruct1() {
            val uselessTimer = object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    layout.setBackgroundColor(Color.argb(255, 255, 0, 0))
                    sefDestruct()
                }
            }
            uselessTimer.start()
        }
    }

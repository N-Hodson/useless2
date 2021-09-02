package com.example.useless

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group

//switch useless
// self destruct button
//look busy button
//chain useless & destruct button  verticalley,center horizantaly


class MainActivity : AppCompatActivity() {

    lateinit var useless: Switch
    lateinit var destruct: Button
    lateinit var busy: Button
    lateinit var layout: ConstraintLayout
    lateinit var UIgroup: Group
    lateinit var Loadgroup: Group
    lateinit var Bar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wireWidgets()
        Loadgroup.visibility = View.INVISIBLE

        useless.setOnCheckedChangeListener { buttonView, ischecked ->
            if (!ischecked) {
                Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show()
                startSwitchTimer()
                useless.isClickable = false

            }
        }

        destruct.setOnClickListener {
            startDestruct1()
        }
        busy.setOnClickListener {
            lookBusy()
        }
    }

    private fun wireWidgets() {
        useless = findViewById(R.id.switch_main_useless)
        destruct = findViewById(R.id.button_main_destruct)
        busy = findViewById(R.id.button_main_busy)
        layout = findViewById(R.id.layout)
        UIgroup = findViewById(R.id.Group_Main_UI)
        Loadgroup = findViewById(R.id.Group_Main_loader)
        Bar = findViewById(R.id.progressBar_Main_Load)
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

        val uselessTimer = object : CountDownTimer(10000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                val red = (Math.random() * 255 + 1).toInt()
                val green = (Math.random() * 255 + 1).toInt()
                val blue = (Math.random() * 255 + 1).toInt()
                layout.setBackgroundColor(Color.argb(255, red, green, blue))
                destruct.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                layout.setBackgroundColor(Color.argb(255, 255, 255, 255))
                finish()
            }
        }
        uselessTimer.start()
    }

    private fun lookBusy() {
        UIgroup.visibility = View.INVISIBLE
        Loadgroup.visibility = View.VISIBLE
        var x = 0
        val uselessTimer = object : CountDownTimer(30000, 300) {
            override fun onTick(millisUntilFinished: Long) {

                Bar.progress = x
                x++
            }

            override fun onFinish() {
                Loadgroup.visibility = View.INVISIBLE
                UIgroup.visibility = View.VISIBLE
            }
        }
        uselessTimer.start()
    }
}

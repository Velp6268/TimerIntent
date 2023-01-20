package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun startTimer(message: String, seconds: Int) {

        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun TimerWalk(view: View) {
        val tempName = findViewById<EditText>(R.id.txt_nameMassage)
        val name = tempName.text.toString()
        val tempSecond = findViewById<EditText>(R.id.txt_timeSeconds)
        val timeSecond = tempSecond.text.toString().toInt()

        startTimer(name, timeSecond )
    }
}
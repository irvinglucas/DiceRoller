package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }

    }

    fun rollDice() {
        val dice = Dice(6)
        val resultTextView = findViewById<TextView>(R.id.textView)
        resultTextView.text = dice.roll().toString()
    }
}
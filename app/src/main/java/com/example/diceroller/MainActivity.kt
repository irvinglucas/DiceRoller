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
            flipCoin()
        }

    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(20)

        val dice1ResultTextView = findViewById<TextView>(R.id.dice1)
        dice1ResultTextView.text = dice1.roll().toString()

        val dice2ResultTextView = findViewById<TextView>(R.id.dice2)
        dice2ResultTextView.text = dice2.roll().toString()
    }

    private fun flipCoin() {
        val coin = Coin()
        val coinSideTextView = findViewById<TextView>(R.id.CoinSideTextView)
        coinSideTextView.text = coin.flip()
    }
}
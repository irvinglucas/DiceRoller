package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// since we have only 6 drawables of a dice, I decided to fix the value here
const val DICE_SIDES = 6

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.button)

        // starts the activity with a random dice side
        rollDice()

        rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val dice = Dice(DICE_SIDES)
        val diceImage = findViewById<ImageView>(R.id.diceImageView)

        val diceRoll = dice.roll()

        val diceSide = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update the right image after rolling the dice
        diceImage.setImageResource(diceSide)
        // set the content description for the TalkBack utility
        diceImage.contentDescription = diceRoll.toString()
    }

}
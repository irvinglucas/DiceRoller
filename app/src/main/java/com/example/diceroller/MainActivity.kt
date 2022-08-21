package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// since we have only 6 drawables of a dice, I decided to fix the value here
//const val DICE_SIDES = 6

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val diceImageView1 = findViewById<ImageView>(R.id.diceImageView)
        val diceImageView2 = findViewById<ImageView>(R.id.diceImageView2)
        // starts the activity with a random dice side

        /*
        * IDK why, but every time the app starts,
        * the dice is starting always in a fixed side
        * but the code is supposed to randomize it.
        * */

        // check random seed kotlin
        rollDice(diceImageView1)
        rollDice(diceImageView2)

        val rollButton = findViewById<Button>(R.id.button)

        rollButton.setOnClickListener {
            rollDice(diceImageView1)
            rollDice(diceImageView2)
        }
    }

    private fun rollDice(diceImageView: ImageView) {
        val dice = Dice(6)

        val diceRoll = dice.roll()

        //val diceImage = findViewById<ImageView>(R.id.diceImageView)

        val diceSide = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update the right image after rolling the dice
        diceImageView.setImageResource(diceSide)
        // set the content description for the TalkBack utility
        diceImageView.contentDescription = diceRoll.toString()
    }
}
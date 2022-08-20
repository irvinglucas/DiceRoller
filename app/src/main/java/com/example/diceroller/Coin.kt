package com.example.diceroller

class Coin() {

    fun flip(): String {
        val randomNumber = (1..10).random()
        return if(randomNumber % 2 == 0) "HEADS"
        else "TAILS"
    }
}
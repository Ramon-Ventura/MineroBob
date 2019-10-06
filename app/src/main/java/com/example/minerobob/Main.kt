package com.example.minerobob

import kotlin.random.Random

fun main() {
    val randomGold = Random.nextInt(1,3)
    val randomStamina = Random.nextInt(1,5)

    val minerBob = Minero("Bob",randomStamina,0,randomGold,estadoBob.MINA)
    minerBob.bobWork()

}
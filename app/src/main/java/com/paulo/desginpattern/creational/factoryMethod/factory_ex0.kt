package com.paulo.desginpattern.creational.factoryMethod

interface Bread {
    fun name(): String
    fun calories(): String
}

class Baguette : Bread {
    override fun name() = "Baguette"
    override fun calories() = " : 65 kcal"
}

class Roll : Bread {
    override fun name() = "Roll"
    override fun calories() = " : 75 kcal"
}

class Brioche : Bread {
    override fun name() = "Brioche"
    override fun calories() = " : 85x kcal"
}

class BreadFactory {
    fun getBread(breadType: Bread) = when (breadType) {
        is Baguette -> Baguette()
        is Roll -> Roll()
        else -> Brioche()
    }
}

fun main() {
    val breadFac =  BreadFactory()
    val bread = breadFac.getBread(Brioche())
    println("${bread.name()} - ${bread.calories()}")
}
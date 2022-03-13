package com.paulo.desginpattern.creational.prototype.example

data class Cat(
    val name: String,
    val type: String,
    val age:Int
)

fun main() {
    val angoraCat = Cat("Bilu", "Angora", 2)

    val persaCat = angoraCat.copy(
        name = "Jaja", type = "persa"
    )


    val cloneCat = persaCat.copy()

    println(cloneCat)
}
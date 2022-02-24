package com.paulo.desginpattern.factory

import java.util.*

interface Animal {
    val id : Int
    val name : String
}

class Cat(override val id: Int): Animal {
    override val name = "Cat"
}
class Dog(override val id: Int): Animal {
    override  val name = "Dog"
}

class AnimalFactory {
    var counter = 0
    fun createAnimal(animalType: String): Animal {
        return when (animalType.lowercase(Locale.getDefault())) {
            "cat" -> Cat(++counter)
            "dog" -> Dog(++counter)
            else -> throw RuntimeException("Unknown animal $animalType")
        }
    }
}


fun main() {
    // usando o polimorfismo
    val animalTypes = listOf("dog", "dog", "cat", "dog", "cat", "cat")
    val factory = AnimalFactory()
    for (t in animalTypes) {
        val c = factory.createAnimal(t)
        println("${c.id} - ${c.name}")
    }

}
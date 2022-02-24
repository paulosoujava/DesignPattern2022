package com.paulo.desginpattern.factory

import java.util.*
//CONTRACT
interface Animal1 {
    val id: Int
    val name: String
}

//CATS CLASS CONCRETE AND FACTORY SPECIFIC THE ANIMAL CAT
class CatFactory {
    fun createDog(breed: String, id: Int) = when(breed.trim().lowercase(Locale.getDefault())) {
        "persian" -> Persian(id, "persian")
        "siamese" -> Siamese(id,"siamese")
        "russian blue" -> RussianBlue(id,"russian blue")
        else -> throw RuntimeException("Unknown dog breed $breed")
    } }
class Persian(override val id: Int, override val name: String): Animal1
class Siamese(override val id: Int, override val name: String): Animal1
class RussianBlue(override val id: Int, override val name: String): Animal1

//DOG CLASS CONCRETE AND FACTORY SPECIFIC THE ANIMAL DOG
class DogFactory {
    fun createDog(breed: String, id: Int) = when(breed.trim().lowercase(Locale.getDefault())) {
        "beagle" -> Beagle(id, "beagle")
        "bulldog" -> Bulldog(id, "bulldog")
        else -> throw RuntimeException("Unknown dog breed $breed")
    } }
class Beagle(override val id: Int, override val name: String): Animal1
class Bulldog(override val id: Int, override val name: String): Animal1

//FACTORY GERAL
class AnimalFactory1 {
    var counter = 0
    private val dogFactory = DogFactory()
    private val catFactory = CatFactory()
    fun createAnimal(animalType: String, animalBreed: String): Animal1 {
        return when (animalType.trim().lowercase(Locale.getDefault())) {
            "cat" -> catFactory.createDog(animalBreed, ++counter)
            "dog" -> dogFactory.createDog(animalBreed, ++counter)
            else -> throw RuntimeException("Unknown animal $animalType")
        }
    }
}


fun main() {
    val animalTypes = listOf(
        "dog" to "bulldog",
        "dog" to "beagle",
        "cat" to "persian",
        "cat" to "russian blue",
        "cat" to "siamese"
    )
    val factory = AnimalFactory1()

    for ((type, breed) in animalTypes) {
        val c = factory.createAnimal(type, breed)
        println(c.name)
    }

}
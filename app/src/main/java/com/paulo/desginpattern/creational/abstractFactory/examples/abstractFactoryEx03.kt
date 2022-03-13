package com.paulo.desginpattern.creational.abstractFactory.examples

import java.lang.IllegalArgumentException


interface Animal {
    val speak: String
}

class Dog(override val speak: String) : Animal
class Cat(override val speak: String) : Animal

abstract class AnimalFactory {
    abstract fun makeAnimal(): Animal
    companion object {
        inline fun <reified T: Animal> createFactory(): AnimalFactory =
            when(T::class){
                Dog::class -> CatFactory()
                Cat::class -> DogFactory()
                else -> throw  IllegalArgumentException("Arghhh")
            }
    }
}

class CatFactory : AnimalFactory() {
    override fun makeAnimal(): Animal  =  Dog("AU AU")


}

class DogFactory : AnimalFactory() {
    override fun makeAnimal(): Animal = Cat("MIAU ")
}

fun main() {
    val animalFactory = AnimalFactory.createFactory<Dog>()
    val dog = animalFactory.makeAnimal()
    println("Created datasource ${dog.speak }")
}


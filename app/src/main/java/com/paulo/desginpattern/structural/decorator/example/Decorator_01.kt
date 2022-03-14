package com.paulo.desginpattern.structural.decorator.example

/*
Attach new behaviour to an object
without altering existing code
Overriding behaviour
 */

interface CoffeeMachine {
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

class NormalCoffeeMachine : CoffeeMachine {
    override fun makeSmallCoffee() {
        println("NORMAL SMALL COFFEE")
    }

    override fun makeLargeCoffee() {
        println("NORMAL LARGE COFFEE")
    }
}

//Decorator
class EnhancedCoffeeMachine(private val cfeM: CoffeeMachine) : CoffeeMachine by cfeM {

    //overriding behaviour
    override fun makeSmallCoffee() {
        println("ENHANCED LARGE COFFEE")
    }

    //extending behaviour
    fun makeMilkCoffee(){
        println("Enhanced coffee machine: Making milk coffee")
        cfeM.makeSmallCoffee()
        println("Enhanced coffee machine: adding milk ")
    }
}

fun main() {
    val normalMachine = NormalCoffeeMachine()
    val enhancedCoffeeMachine = EnhancedCoffeeMachine(normalMachine)

    enhancedCoffeeMachine.makeSmallCoffee()
    enhancedCoffeeMachine.makeLargeCoffee()
    enhancedCoffeeMachine.makeMilkCoffee()
}
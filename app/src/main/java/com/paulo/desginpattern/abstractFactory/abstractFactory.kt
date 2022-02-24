package com.paulo.desginpattern.abstractFactory

interface Bread {
    fun name(): String
    fun calories(): String
}
interface Filling{
    fun name(): String
    fun calories(): String
}

abstract class  AbstractFactory{
    abstract  fun getBread( bread: Bread): Bread
    abstract  fun getFilling( filling: Filling):Filling
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
    override fun calories() = " : 85 kcal"
}

class Cheese: Filling{
    override fun name() = "Queijo"
    override fun calories() = " : 18 kcal"
}
class Tomato: Filling{
    override fun name() = "Tomate"
    override fun calories() = " : 5 kcal"
}

class BreadFactory: AbstractFactory() {
    override fun getBread(breadType: Bread) = when (breadType) {
        is Baguette -> Baguette()
        is Roll -> Roll()
        else -> Brioche()
    }

    override fun getFilling(filling: Filling): Filling {
        TODO("Not yet implemented")
    }
}
class FillingFactory : AbstractFactory() {
    override fun getBread(bread: Bread): Bread {
        TODO("Not yet implemented")
    }

    override fun getFilling(filling: Filling): Filling {
        return when (filling) {
            is Tomato -> Tomato()
            else -> Cheese()
        }

    }
}

fun main() {
    val breadFac =  BreadFactory()
    val bread = breadFac.getBread(Brioche())
    println("${bread.name()} - ${bread.calories()}")
}
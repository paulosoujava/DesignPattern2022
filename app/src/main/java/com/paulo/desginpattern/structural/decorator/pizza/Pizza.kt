package com.paulo.desginpattern.structural.decorator.pizza

abstract class Pizza {
    abstract fun getDescricao(): String
    abstract fun getPreco(): Float
}

class PizzaFrango : Pizza() {
    override fun getDescricao(): String {
        return "Deliciosa pizza de frango"
    }

    override fun getPreco(): Float {
        return 19f
    }

}

class PizzaCalabresa : Pizza() {
    override fun getDescricao(): String {
        return "Deliciosa pizza de Calabresa"
    }

    override fun getPreco(): Float {
        return 25f
    }

}

class PizzaQueijo : Pizza() {
    override fun getDescricao(): String {
        return "Deliciosa pizza de Queijo"
    }

    override fun getPreco(): Float {
        return 22f
    }

}

abstract class AcrescimoDecorator(val pizza: Pizza) : Pizza()

class BordaRequeijao(pizza: Pizza) : AcrescimoDecorator(pizza) {
    override fun getDescricao(): String {
        return pizza.getDescricao() + " + Borda recheada de requeijão"
    }

    override fun getPreco(): Float {
        return pizza.getPreco() + 8.50f
    }

}

class MassIntegral(pizza: Pizza) : AcrescimoDecorator(pizza) {
    override fun getDescricao(): String {
        return pizza.getDescricao() + " + Massa integral"
    }

    override fun getPreco(): Float {
        return pizza.getPreco() + 5f
    }

}

fun main() {
    val pizzaQueijo = PizzaQueijo()

    println("Desc::" + pizzaQueijo.getDescricao())
    println("Valor::" + pizzaQueijo.getPreco())

    println("Add borda")
    val borda = BordaRequeijao(pizzaQueijo)
    println("Desc::" + borda.getDescricao())
    println("Valor::" + borda.getPreco())

    println("Add Massa")
    val massa = MassIntegral(borda)
    println("Desc::" + massa.getDescricao())
    println("Valor::" + massa.getPreco())


}
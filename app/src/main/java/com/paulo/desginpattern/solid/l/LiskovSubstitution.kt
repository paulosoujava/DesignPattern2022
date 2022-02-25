package com.paulo.desginpattern.solid.l
/*
Princípio da Substituição de Liskov —
As classes derivadas devem ser substituíveis por suas classes bases.
 */

interface Veiculo {
    fun calibrarPneu()
    fun moverSe()
    fun tipo():String
}

abstract class CoisasDeCarro : Veiculo {
    open fun trocarOleo(): Nothing = TODO()
    open fun colocarGasolina(): Nothing = TODO()
    override fun calibrarPneu(): Nothing = TODO()
    override fun moverSe(): Nothing = TODO()
}
/*
Esta  classe Carro que é uma filha de Veiculo
sabe fazer coisas que seu pai faz, dentro de sua realidade ( logica na classe )

 */
class Carro() : CoisasDeCarro() {
    override fun tipo() = "Carro"
    override fun trocarOleo(): Nothing {
        return super.trocarOleo()
    }

    override fun colocarGasolina(): Nothing {
        return super.colocarGasolina()
    }

    override fun calibrarPneu(): Nothing {
        return super.calibrarPneu()
    }

    override fun moverSe(): Nothing {
        return super.moverSe()
    }
}

abstract class CoisasDeBicicleta: Veiculo{
    override fun calibrarPneu(): Nothing = TODO()
    override fun moverSe(): Nothing = TODO()
}
/*
Esta nova classe Bicilicleta que é uma filha de Veiculo
sabe fazer coisas que seu pai faz, dentro de sua realidade ( logica na classe )

 */
class Bicicleta(): CoisasDeBicicleta() {
    override fun tipo() = "BIKE"
    override fun calibrarPneu(): Nothing {
        return super.calibrarPneu()
    }

    override fun moverSe(): Nothing {
        return super.moverSe()
    }
}
fun getVeiculo(veiculo: Veiculo){
    println("Indo de ${veiculo.tipo()}")
}

fun main() {
    val list = listOf(Bicicleta(), Carro())
    list.forEach {
        getVeiculo(it)
    }


}

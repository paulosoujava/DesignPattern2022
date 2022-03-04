package com.paulo.desginpattern.creational.builder

data class Casa2(
    var temMudo: Boolean = false,
    var temGaragem: Boolean = false,
    var temQtdGaragem: Int = 0,
    var temPiscina: Boolean = false,
    var temSuite: Boolean = false,
)

fun main() {
    val casaDePobre = Casa2().apply{
        temGaragem = true
    }

    val casaDeRico = Casa2().apply {
        temGaragem = true
        temGaragem = true
        temQtdGaragem= 4
        temPiscina = true
        temSuite= true
    }

    println(casaDePobre)
    println(casaDeRico)
}
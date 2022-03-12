package com.paulo.desginpattern.creational.factoryMethod.realExample

class BancoCaixaBoleto20Dias(override val valor: Float) : Boleto(valor) {
    init {
        this.multa = 0.1f
        this.desconto = 0.1f
        this.juros = 0.1f
    }
}
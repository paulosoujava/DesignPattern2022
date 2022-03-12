package com.paulo.desginpattern.creational.factoryMethod.realExample

class BancoCaixaBoleto10Dias(override val valor: Float) : Boleto(valor) {
    init {
        this.multa = 0.05f
        this.desconto = 0.05f
        this.juros = 0.05f
    }
}
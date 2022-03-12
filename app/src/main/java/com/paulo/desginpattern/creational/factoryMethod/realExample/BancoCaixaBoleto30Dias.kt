package com.paulo.desginpattern.creational.factoryMethod.realExample

class BancoCaixaBoleto30Dias(override val valor: Float) : Boleto(valor) {
    init {
        this.multa = 0.10f
        this.desconto = 0.10f
        this.juros = 0.10f
    }
}
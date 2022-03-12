package com.paulo.desginpattern.creational.factoryMethod.realExample

abstract class Boleto(open val valor: Float) {

     var juros: Float = 0.0f
     var desconto: Float = 0.0f
     var multa: Float = 0.0f

    fun calculaJuros() = valor * this.juros

    fun calculaDesconto() = valor * this.desconto

    fun calculaMulta() = valor * this.multa
}
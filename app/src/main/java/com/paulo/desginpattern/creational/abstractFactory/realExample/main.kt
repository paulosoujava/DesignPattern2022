package com.paulo.desginpattern.creational.abstractFactory.realExample

import com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.Banco
import com.paulo.desginpattern.creational.abstractFactory.realExample.factory.BBCalculoFactory
import com.paulo.desginpattern.creational.abstractFactory.realExample.factory.CaixaCalculoFactory

fun main() {
    val banco = Banco()

    //fabrica calculos para boletos de caixa
    val factoryCaixa = CaixaCalculoFactory()

    //fabrica calculos para boletos do BB
    val factoryBB = BBCalculoFactory()

    //Boleto da caixa
    println("BOLETO da Caixa ###")
    println( banco.gerarBoleto(100f, factoryCaixa))

    //Boleto da BB
    println("BOLETO da BB ###")
    println( banco.gerarBoleto(100f, factoryBB))
}
package com.paulo.desginpattern.creational.factoryMethod.realExample

fun main() {
    val banco = BancoCaixa()
    banco.gerarBoleto(Vencimento.DEZ,100f)
    banco.gerarBoleto(Vencimento.VINTE, 100f)
    banco.gerarBoleto(Vencimento.TRINA, 100f)
}
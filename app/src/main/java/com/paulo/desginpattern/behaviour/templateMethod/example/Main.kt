package com.paulo.desginpattern.behaviour.templateMethod.example

fun main() {
    val valor = 100f
    val gateway = Gateway()

    println("Credito")
    val pgCredito = PagamentoCredito(valor, gateway)
    pgCredito.realizarCobranca()


    println("Debito")
    val pgDebito = PagamentoDebito(valor, gateway)
    pgDebito.realizarCobranca()


    println("Dinheiro")
    val pgDinheiro = PagamentoDinheiro(valor, gateway)
    pgDinheiro.realizarCobranca()
}
package com.paulo.desginpattern.behaviour.state.example

fun main() {
    val pedido = Pedido()

    println(pedido.actualState())

    //pedido.despachar()
    pedido.pagar()
    pedido.despachar()

    println(pedido.actualState())
}
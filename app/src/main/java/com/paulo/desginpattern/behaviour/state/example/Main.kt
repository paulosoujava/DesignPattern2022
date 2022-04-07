package com.paulo.desginpattern.behaviour.state.example

fun main() {
    val pedido = Pedido()

    println(pedido.actualState())

   // CanceladoState(pedido).cancelarPedido()
    PagoState(pedido).sucessoAoPager()

    println(pedido.actualState())

    PagoState(pedido).despacharPedido()

    println(pedido.actualState())
}
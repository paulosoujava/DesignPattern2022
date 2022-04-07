package com.paulo.desginpattern.behaviour.state.example

import java.lang.Exception

class CanceladoState(val pedido: Pedido): State {
    override fun sucessoAoPager() {
        throw  Exception("Operação não suportada, o pedido se encontra cancelado.")
    }

    override fun cancelarPedido() {
        throw  Exception("Operação não suportada, pedido já cancelado.")
    }

    override fun despacharPedido() {
        throw  Exception("Operação não suportada, o pedido se encontra cancelado.")
    }
}
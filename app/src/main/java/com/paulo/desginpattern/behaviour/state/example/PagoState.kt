package com.paulo.desginpattern.behaviour.state.example

import java.lang.Exception

class PagoState(val pedido: Pedido): State {

    override fun sucessoAoPager() {
        throw Exception("Operação não suportada, o pedido já foi pago.")
    }

    override fun cancelarPedido() {
        pedido.estadoAtual = pedido.cancelado
    }

    override fun despacharPedido() {
        pedido.estadoAtual = pedido.enviado
    }
}
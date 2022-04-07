package com.paulo.desginpattern.behaviour.state.example

class PagoState(val pedido: Pedido): State {
    override fun sucessoAoPager() {
        pedido.estadoAtual = pedido.pago
    }

    override fun cancelarPedido() {
        pedido.estadoAtual = pedido.cancelado
    }

    override fun despacharPedido() {
        pedido.estadoAtual = pedido.enviado
    }
}
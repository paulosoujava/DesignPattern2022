package com.paulo.desginpattern.behaviour.state.example

class AguardandoPagamentoState(val pedido: Pedido) : State {
    override fun sucessoAoPager() {
        pedido.estadoAtual = pedido.pago
    }

    override fun cancelarPedido() {
        pedido.actualState()
    }

    override fun despacharPedido() {
        pedido.actualState()
    }
}
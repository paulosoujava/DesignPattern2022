package com.paulo.desginpattern.behaviour.state.example

class EnviadoState(val pedido: Pedido): State {
    override fun sucessoAoPager() {
        pedido.actualState()
    }

    override fun cancelarPedido() {
        pedido.actualState()
    }

    override fun despacharPedido() {
        pedido.actualState()
    }
}
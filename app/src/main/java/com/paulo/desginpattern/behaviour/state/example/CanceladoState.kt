package com.paulo.desginpattern.behaviour.state.example

class CanceladoState(val pedido: Pedido): State {
    override fun sucessoAoPager() {
        print("Sem estado para cancelar o pedido")
        pedido.actualState()
    }

    override fun cancelarPedido() {
        print("Sem estado para cancelar o pedido")
        pedido.actualState()
    }

    override fun despacharPedido() {
        print("Sem estado para cancelar o pedido")
        pedido.actualState()
    }
}
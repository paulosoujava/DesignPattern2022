package com.paulo.desginpattern.behaviour.state.example

import java.lang.Exception

class AguardandoPagamentoState(val pedido: Pedido) : State {
    override fun sucessoAoPager() {
        pedido.estadoAtual = pedido.pago
    }

    override fun cancelarPedido() {
        throw Exception("Operação não suportada, o pedido ainda não foi pago.")
    }

    override fun despacharPedido() {
        throw Exception("Operação não suportada, o pedido ainda não foi pago.")
    }
}
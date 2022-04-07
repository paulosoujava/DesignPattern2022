package com.paulo.desginpattern.behaviour.state.example

import java.lang.Exception

class EnviadoState(val pedido: Pedido): State {
    override fun sucessoAoPager() {
        throw Exception("Operação não suportada, o pedido já foi pago e enviado.")
    }

    override fun cancelarPedido() {
        throw Exception("Operação não suportada, o pedido já foi enviado.")
    }

    override fun despacharPedido() {
        throw Exception("Operação não suportada, o pedido já foi enviado.")
    }
}
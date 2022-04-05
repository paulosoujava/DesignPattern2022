package com.paulo.desginpattern.behaviour.templateMethod.example

class PagamentoDinheiro(valor: Float, gateway: Gateway) : Pagamento(valor, gateway) {

    override fun calcularDesconto(): Float {
        return valor * 0.01f
    }
}
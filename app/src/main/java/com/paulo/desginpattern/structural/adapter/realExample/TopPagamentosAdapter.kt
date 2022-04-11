package com.paulo.desginpattern.structural.adapter.realExample

class TopPagamentosAdapter(topPagamento: TopPagamento): Gateway {
    override fun setValor(valor: Float) {
        TODO("Not yet implemented")
    }

    override fun setParcelas(parcelas: Int) {
        TODO("Not yet implemented")
    }

    override fun setNumeroCartao(numeroCartao: String) {
        TODO("Not yet implemented")
    }

    override fun setCvv(cvv: String) {
        TODO("Not yet implemented")
    }

    override fun validarCartao(): Boolean {
        TODO("Not yet implemented")
    }

    override fun realizarPagamento(): Boolean {
        TODO("Not yet implemented")
    }
}
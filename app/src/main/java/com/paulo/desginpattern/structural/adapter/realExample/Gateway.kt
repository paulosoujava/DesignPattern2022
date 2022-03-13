package com.paulo.desginpattern.structural.adapter.realExample

interface Gateway {
    fun setValor(valor: Float)
    fun setParcelas(parcelas: Int)
    fun setNumeroCartao(numeroCartao: String)
    fun setCvv(cvv: String)
    fun validarCartao(): Boolean
    fun realizarPagamento(): Boolean
}
package com.paulo.desginpattern.behaviour.templateMethod.example

class PagamentoDebito(valor: Float, gateway: Gateway) : Pagamento(valor, gateway) {
    //calcula a taxa do Gateway
    override fun calcularTaxa(): Float{
        return 4f //Retorna uma taxa de 4 reais.
    }

    override fun calcularDesconto(): Float{
        return valor * 0.05f
    }

}
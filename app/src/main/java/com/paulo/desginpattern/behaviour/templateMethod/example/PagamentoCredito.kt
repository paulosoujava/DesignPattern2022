package com.paulo.desginpattern.behaviour.templateMethod.example

class PagamentoCredito(valor: Float, gateway: Gateway) : Pagamento(valor, gateway) {
    //calcula a taxa do Gateway
    override fun calcularTaxa(): Float{
        return valor * 0.05f //Retorna uma taxa de 5% o valor do pagamento.
    }

    override fun calcularDesconto(): Float {
        //Se o valor pago for maior que 300 reais.
        if(valor > 300){
            return valor * 0.02f //Retorna um desconto de 2% sob o valor do pagamento.
        }
        return 0f
    }
}
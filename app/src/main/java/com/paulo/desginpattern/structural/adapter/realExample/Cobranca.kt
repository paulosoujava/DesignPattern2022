package com.paulo.desginpattern.structural.adapter.realExample

class Cobranca(val gateway: Gateway) {

     fun setValor(valor:Float){
        gateway.setValor(valor)
    }

     fun setParcelas(parcelas: Int) {
       gateway.setParcelas(parcelas)
    }

     fun setNumeroCartao(numeroCartao: String) {
        gateway.setNumeroCartao(numeroCartao)
    }

     fun setCvv(cvv: String) {
        gateway.setCvv(cvv)
    }


     fun realizarPagamento(): Boolean {
        if(gateway.validarCartao()){
            return gateway.realizarPagamento()
        }
         return false
    }
}
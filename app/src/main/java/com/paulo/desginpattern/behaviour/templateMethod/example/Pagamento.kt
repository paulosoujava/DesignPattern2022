package com.paulo.desginpattern.behaviour.templateMethod.example

abstract class Pagamento(
    val valor: Float,
    val gateway: Gateway
) {

    //Hook (gancho) - Implementação Mínima. Pode ser sobreescrito pelas subclasses.
    open fun calcularTaxa(): Float = 0f



    //Será implementado pelas subclasses.
    abstract fun calcularDesconto(): Float

    fun realizarCobranca(): Boolean{
        //Calcula o valor total (Valor do pagamento + taxa - desconto).
        val valorFinal = valor + calcularTaxa() - calcularDesconto()

        println("""
             Valor: $valor
             Taxa: ${calcularTaxa()}
             Desconto: ${calcularDesconto()}
            """)

        return  gateway.cobrar(valorFinal)//Delega a cobrança para o Gateway.
    }

}
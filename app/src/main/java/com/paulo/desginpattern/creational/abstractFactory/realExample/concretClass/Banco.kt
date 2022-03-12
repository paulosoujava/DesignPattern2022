package com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass

import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.CalculoFactory

class Banco {
    /*
    O Banco recebe no método gerarBoleto() o valor do boleto a ser crado
    e a fábrica que deve utilizar para criar os cálculos
     */
    fun gerarBoleto(valor: Float, factory: CalculoFactory): CalcularBoleto{
        //passa o valor e a fábrica para o boleto
        //Boleto utiliza a fábrica recebida para o Juros, Desconto e Multa
        val boleto = CalcularBoleto(valor, factory)
        println("""
            Boleto gerado com sucesso no valor de ${valor}
            Valor do Juros: ${boleto.calcularJuro()}
            Valor do Desconto: ${boleto.calcularDesconto()}
            Valor da Multa: ${boleto.calcularMulta()}
            """)

        return boleto
    }
}
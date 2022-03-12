package com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass

import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.CalculoFactory
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Desconto
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Juros
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Multa

class CalcularBoleto(private val valor: Float, val factory: CalculoFactory) {

    // guarda referencia ao objeto do tipo juros
    private var juros: Juros =
        factory.criarJuros()
    // guarda referencia ao objeto do tipo Desconto
    private var desconto: Desconto =
        factory.criarDesconto()
    // guarda referencia ao objeto do tipo Multa
    private var multa: Multa =
        factory.criarMulta()

    fun calcularJuro(): Float {
        //retorna o valor do juros em reais
        // usa o método getJuros odo objeto do tipo Juros
        return this.valor * juros.getJuros()
    }

    fun calcularMulta(): Float {
        //retorna o valor do juros em reais
        // usa o método getJuros odo objeto do tipo Multa
        return this.valor * multa.getMulta()
    }

    fun calcularDesconto(): Float {
        //retorna o valor do juros em reais
        // usa o método getJuros odo objeto do tipo Desconto
        return this.valor * desconto.getDesconto()
    }
}
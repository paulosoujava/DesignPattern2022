package com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.caixa

import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Juros

class CaixaJuros : Juros {
    override fun getJuros(): Float {
        return 0.2f //retorna 2%
    }
}
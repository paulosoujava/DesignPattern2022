package com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.caixa

import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Desconto

class CaixDesconto : Desconto {
    override fun getDesconto(): Float {
        return 0.1f //retorna 10%
    }
}
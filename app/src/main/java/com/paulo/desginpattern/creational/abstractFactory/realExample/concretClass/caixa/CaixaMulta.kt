package com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.caixa

import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Multa

class CaixaMulta : Multa {
    override fun getMulta(): Float {
        return 0.02f
    }
}
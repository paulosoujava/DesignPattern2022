package com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.bb

import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Juros

class BBJuros : Juros {
    override fun getJuros(): Float {
        return 0.03f  //retorna 3%
    }
}
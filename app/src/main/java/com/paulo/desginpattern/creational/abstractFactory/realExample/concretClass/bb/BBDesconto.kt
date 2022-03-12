package com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.bb

import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Desconto

class BBDesconto : Desconto {
    override fun getDesconto(): Float {
        return 0.05f //5$%
    }
}
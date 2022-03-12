package com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.bb

import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Multa

class BBMulta : Multa {
    override fun getMulta(): Float {
        return 0.05f
    }
}
package com.paulo.desginpattern.creational.abstractFactory.realExample.factory

import com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.bb.BBDesconto
import com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.bb.BBJuros
import com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.bb.BBMulta
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.CalculoFactory
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Desconto
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Juros
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Multa

class BBCalculoFactory : CalculoFactory {
    override fun criarJuros(): Juros {
        return BBJuros() //retonar um objeto do tipo Juros
    }

    override fun criarDesconto(): Desconto {
        return  BBDesconto()//retonar um objeto do tipo Desconto
    }

    override fun criarMulta(): Multa {
        return  BBMulta()///retonar um objeto do tipo Multa
    }
}
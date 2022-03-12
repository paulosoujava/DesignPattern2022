package com.paulo.desginpattern.creational.abstractFactory.realExample.factory

import com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.caixa.CaixDesconto
import com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.caixa.CaixaJuros
import com.paulo.desginpattern.creational.abstractFactory.realExample.concretClass.caixa.CaixaMulta
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.CalculoFactory
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Desconto
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Juros
import com.paulo.desginpattern.creational.abstractFactory.realExample.contract.Multa

class CaixaCalculoFactory : CalculoFactory {
    override fun criarJuros(): Juros {
        return CaixaJuros() //retonar um objeto do tipo Juros
    }

    override fun criarDesconto(): Desconto {
        return  CaixDesconto()//retonar um objeto do tipo Desconto
    }

    override fun criarMulta(): Multa {
        return  CaixaMulta()///retonar um objeto do tipo Multa
    }
}
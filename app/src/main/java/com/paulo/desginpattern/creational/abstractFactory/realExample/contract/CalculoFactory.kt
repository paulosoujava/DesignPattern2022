package com.paulo.desginpattern.creational.abstractFactory.realExample.contract

interface CalculoFactory {
    //uma classe fabrica deve ter um metodo para criar um objeto correto de cada tipo
    fun criarJuros(): Juros // cria u objeto do tipo juros
    fun criarDesconto(): Desconto// cria u objeto do tipo Desconto
    fun criarMulta(): Multa// cria u objeto do tipo Multa
}
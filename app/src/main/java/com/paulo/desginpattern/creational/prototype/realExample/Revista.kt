package com.paulo.desginpattern.creational.prototype.realExample

data class Revista(
    var nome: String = "",
    var edicao: String = ""
): Prototype {

    override fun clone(): Prototype {
        val clone = Revista()

        clone.nome = this.nome
        clone.edicao = this.edicao

        return clone
    }
}
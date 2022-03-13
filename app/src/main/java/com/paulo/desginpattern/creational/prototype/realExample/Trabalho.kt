package com.paulo.desginpattern.creational.prototype.realExample

data class Trabalho(
    var nome: String = "",
    var autor: String = "",
    var tipo: String = ""
): Prototype {

    override fun clone(): Prototype {
        val clone = Trabalho()
        clone.autor = this.autor
        clone.nome = this.nome
        clone.tipo = this.tipo

        return clone
    }
}
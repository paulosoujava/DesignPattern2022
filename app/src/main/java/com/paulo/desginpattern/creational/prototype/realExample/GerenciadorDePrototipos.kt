package com.paulo.desginpattern.creational.prototype.realExample

class GerenciadorDePrototipos {
    private val listPrototipos = mutableMapOf<String, Prototype>()
    init {
        val livro = Livro("Desconhecido", "Desconhecido",100)
        listPrototipos["LIVRO"] = livro

        val revista = Revista("Desconhecido", "Num 1")
        listPrototipos["REVISTA"] = revista

        val trabalho = Trabalho("Paulo", "Eu", "Developer")
        listPrototipos["TRABALHO"] = trabalho
    }

    fun getInstance(key: String): Prototype? {
        return this.listPrototipos[key]
    }
}
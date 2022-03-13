package com.paulo.desginpattern.creational.prototype.realExample

data class Livro(
    var nome: String = "",
    var autor: String = "",
    var numeroPaginas: Int = 0
) : Prototype {

    //método responsavvel por clonar o objeto livro
   override fun clone(): Prototype {
        //criar uma nova instancia de livro
        val clone = Livro()
        clone.autor = this.autor
        clone.nome = this.nome
        clone.numeroPaginas = this.numeroPaginas
        return clone
    }

}
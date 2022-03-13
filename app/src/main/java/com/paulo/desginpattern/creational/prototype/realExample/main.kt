package com.paulo.desginpattern.creational.prototype.realExample

fun main() {
    val gerenciadorDePrototipos = GerenciadorDePrototipos()

    println(gerenciadorDePrototipos.getInstance("LIVRO"))
    println(gerenciadorDePrototipos.getInstance("REVISTA"))
    println(gerenciadorDePrototipos.getInstance("TRABALHO"))


}
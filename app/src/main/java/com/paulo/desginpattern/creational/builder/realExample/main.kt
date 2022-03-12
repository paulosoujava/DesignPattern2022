package com.paulo.desginpattern.creational.builder.realExample

fun main() {

    //criação do builder de A4
    var a4 = BuilderA4()
    val a3 = BuilderA3()

    //director
    val director = Director(a4)

    director.trocar(a3) // ou a4

    director.getPDF()


}
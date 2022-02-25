package com.paulo.desginpattern.solid.i
/*
Princípio da Segregação de Interfaces
 Muitas interfaces específicas são melhores do que uma interface única geral.

 Vc não deve ter um interface geral onde vc tem que implementar coisas que não vai usar
 Ex com ERRO
 */
interface Animal{
    fun fly():Unit
    fun walk():Unit
}
class Dog: Animal{
    // !! AQUI FERE O PRINCIPIO POIS CACHORRO NAO VOA
    override fun fly() {}

    override fun walk() = TODO()

}
//FAZENDO DO MODO CORRETO
interface AnimalCorrect{
    fun specie():String
}
interface Fly{
    fun fly():String
}
interface Walk{
    fun walk():String
}
class CorrectDog: AnimalCorrect, Walk{
    override fun specie()="SUA ESPECIE"
    override fun walk() = "ANDANDO"
}
class CorrectBird:AnimalCorrect, Fly{
    override fun specie()="SUA ESPECIE"
    override fun fly() = "VOANDO"

}
package com.paulo.solid.o

/*
Se S é um subtipo de T, então objetos do tipo T em um programa podem ser substituídos
por objetos do tipo S sem alterar nenhuma das propriedades desejáveis daquele programa.

Esse princípio diz que você deve ser capaz de estender um comportamento de uma classe sem a
 necessidade de modificá-lo, ou seja, quando novos comportamentos e recursos precisam ser
 adicionados no software, devemos estender e não alterar o código fonte origina
 */
interface Ave {
    val tipo: String
}

interface Voar {
    fun voa(): String
}

interface Bicar {
    fun bicar(): String
}

open class AveQueBicaEvoa(override val tipo: String) : Bicar, Voar, Ave {
    override fun voa() = "SOU UMA ${tipo} BICANDO"
    override fun bicar() = "SOU  UMA ${tipo} E ESTOU BICANDO"
}

open class AveQueVoaEnaoBica(override val tipo: String) :Voar, Ave{
    override fun voa() = "SOU UMA ${tipo} BICANDO"
}



open class Pingum(override val tipo: String) :AveQueVoaEnaoBica(tipo) {
    override fun voa() = "SOU  UMA ${tipo} E ESTOU VOADO"
    fun caminharDancando() ="Estou caminhando"
}

class Andorinha(override val tipo: String) : AveQueBicaEvoa(tipo){
    override fun voa() = "SOU UMA ${tipo} VOADO"
    override fun bicar() = "SOU  UMA ${tipo} E ESTOU BICANDO"
}

class PicaPau(override val tipo: String) :AveQueBicaEvoa(tipo) {
    override fun voa() = "SOU UM ${tipo} VOADO"
    override fun bicar() = "SOU  UMA ${tipo} E ESTOU BICANDO"
}


fun main() {
    val ave = listOf<Ave>(PicaPau("PICAPU"), Andorinha("Andorinha"), Pingum("Pinhuim"))

    ave.forEach {
        when (it) {
            is Pingum -> println("${it.voa()} ${it.caminharDancando()}")
            is Andorinha -> println("${it.bicar()} - ${it.voa()}")
            is PicaPau -> println("${it.bicar()} - ${it.voa()}")
        }
    }
}
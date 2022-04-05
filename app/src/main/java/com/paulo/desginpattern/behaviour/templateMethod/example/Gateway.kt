package com.paulo.desginpattern.behaviour.templateMethod.example

import kotlin.random.Random


class Gateway {
    //simulaçãode uma cobrança - retorna true ou false de forma randômica
    fun cobrar(valor: Float): Boolean{
        println("R$ $valor")
        val respostas = listOf<Boolean>(true, false)
        return respostas[Random.nextInt(0, 1)]
    }
}
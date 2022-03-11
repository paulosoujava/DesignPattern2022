package com.paulo.desginpattern.structural.adapter

import kotlin.math.sqrt

/*
Também conhecido como: adaptador, wrapper
o Adapter é um padrão de projeto estrutural que permite objetos com interfaces
incompatíveis colcaborarem entre si
 */
/*
Digamos que vocÊ tenha classes com interfaces compatíveir:
RoundHole ( buraco redondo)
RoundPeg ( Pino redondo )
 */

class RoundHole(radius: Int = 0) {
    fun getRadius(): Double {
        TODO()
    }//retorna o raio do buraco

    fun fits(peg: RoundPeg): Boolean {
        TODO()
    }
}

open class RoundPeg(width: Int = 0) {

    open fun getRadius(): Double {
        TODO()
    }
}

// MAs tem uma classe incompatível: SquarePeg ( Pino Quadrado)
class SquarePeg(width: Int) {
    fun getWidth(): Int {
        TODO()
        //retorna a largura do pino quadrado
    }

}
/*
uma classe adaptadora permite que vc encaixe pinos quadrados em buracos redondos
ela estende a classe roundedPeg para permitir que objetos do adaptador ajam como pinos
redondos
*/

class SquarePegAdapter(val peg: SquarePeg) : RoundPeg() {
    /*
    na verdade o adaptador contem uma instância da classe SquarePeg
     */

    /*
       O adaptador finge que é um pino redondo com um raio que encaixaria
       o pino quadrado que o adaptador está envolvendo
        */
    override fun getRadius() = peg.getWidth() * sqrt(2.0) / 2


    /*
    em algum lugar do código cliente
     */
    val hole = RoundHole(5)

    val rpeg = RoundPeg(10)
    val small_sqpeg = SquarePeg(5)
    val large_sqpeg = SquarePeg(10)

    val small_sqpeg_adt = SquarePegAdapter(small_sqpeg)
    val large_sqpeg_adt = SquarePegAdapter(large_sqpeg)

    init {
        hole.fits(rpeg)

        //isso nao vai compilar ( tipos incompativeis)
        //hole.fits(small_sqpeg)

        //uando o adaptador para compilar o que acima não nos permitia
        hole.fits(small_sqpeg_adt)
    }
}

package com.paulo.desginpattern.creational.builder.example

// USed when we have multiple parameters to initialize
// for many parameters, It's impractical to build all constructors
class Casa private constructor(builder: Builder) {
    var comMuro: Boolean? = null
    var comPiscina: Boolean? = false
    var comGaragem: Boolean? = false
    var vagaDeGaragem: Int? = 0
    var comSuite: Boolean? = false

    class Builder {
        var comMuro: Boolean? = null
        var comPiscina: Boolean? = false
        var comGaragem: Boolean? = false
        var vagaDeGaragem: Int? = 0
        var comSuite: Boolean? = false

        fun setMuro( has: Boolean) = apply { this.comMuro = comMuro }
        fun setPiscina( has: Boolean) = apply { this.comPiscina = comPiscina }
        fun setGaragem( has: Boolean) = apply { this.comGaragem = comGaragem }
        fun setGaragemQtd( has: Int) = apply { this.vagaDeGaragem = vagaDeGaragem }
        fun setSuite( has: Boolean) = apply { this.comSuite = comSuite }
        fun build() = Casa(this)


        fun getMuro() = comMuro
        fun getPiscina() = comPiscina
        fun getGaragem() = comGaragem
        fun getGaragemQtd() = vagaDeGaragem
        fun getSuite() = comSuite
    }

    init {
        comGaragem = builder.getGaragem()
        comMuro = builder.getMuro()
        comPiscina = builder.getPiscina()
        comSuite = builder.getSuite()
        vagaDeGaragem = builder.getGaragemQtd()
    }

}

fun main() {
    val casaDePobre = Casa.Builder()
        .setMuro(true)
        .build()
    val casaDeRico = Casa.Builder()
        .setMuro(true)
        .setPiscina(true)
        .setGaragem(true)
        .setGaragemQtd(4)
        .setSuite(true)
        .build()
}

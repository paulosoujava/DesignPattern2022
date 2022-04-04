package com.paulo.desginpattern.behaviour.strategy.pedido

abstract class Pedido(private var valor: Float, private val tipoFrete: Frete) {
    fun calculaFrete(): Float {
        return tipoFrete.calculaFrete(valor)
    }
    fun tipeFrete() = when (tipoFrete) {
        is FreteExpresso -> "Expresso: Taxa 0.05"
        else -> "Comum: Taxa 0.01"

    }
}

//********************************************
// TIPOS DE PEDIDIOS
data class PedidoEletronico(
    var valor: Float,
    val tipoFrete: Frete
) : Pedido(valor, tipoFrete) {
    var name: String = ""
    fun decription() {
        println(
            " Name : $name  Valor: $valor,   Frete: ${tipeFrete()} Total: ${calculaFrete()}"
        )
    }
}


data class PedidoMoveis(
    var valor: Float,
    val tipoFrete: Frete
) : Pedido(valor, tipoFrete) {
    var name: String = ""
    var madeiraTipo: String = ""

    fun decription() {
        println(
            " Name : $name tipo: $madeiraTipo Valor: $valor  Frete: ${tipeFrete()} Total: ${calculaFrete()}"
        )
    }
}


//************************************************************************
//FAMILIA DE FRETES
interface Frete {
    fun calculaFrete(valorPedido: Float): Float
}

class FreteComun : Frete {
    override fun calculaFrete(valorPedido: Float): Float {
        return valorPedido * 0.05f
    }
}

class FreteExpresso : Frete {
    override fun calculaFrete(valorPedido: Float): Float {
        return valorPedido * 0.1f
    }
}
//****************************************************************************************


fun main() {
    val freteComun = FreteComun()
    val freteExpresso = FreteExpresso()

    println("Pedido ELETRONICO")
    val pedido = PedidoEletronico(10_000f, freteComun)
    pedido.name = "Apple"
    pedido.decription()
    val pedido2 = PedidoEletronico(130f, freteExpresso)
    pedido2.name = "Tablet"
    pedido2.decription()
    //println(pedido.calculaFrete())
    //println(pedido2.calculaFrete())


    println("Pedido Movel")
    val pedidoM = PedidoMoveis(100f, freteComun)
    pedidoM.madeiraTipo = "MDF"
    pedidoM.name = "Mesa de escritorio"
    pedidoM.decription()
    val pedidoM2 = PedidoMoveis(130f, freteExpresso)
    pedidoM2.madeiraTipo = "MDF"
    pedidoM2.name = "Mesa de canto"
    pedidoM2.decription()
    //println(pedidoM.calculaFrete())
    //println(pedidoM2.calculaFrete()
}
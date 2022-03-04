package com.paulo.solid.d
/*
Princípio da Inversão de Dependência
Dependa de abstrações e não de implementações.

Vc deve fornecer a classe a abstracao correta para o uso do pedido

JEITO ERRADO
 */

class Cortar( private val oQueCortar: String ){
    private val faca: String = "Cortando com a faca"

    fun cortar(){
        println("Estou cortando ${oQueCortar} com a $faca")
    }
}

//JEITO CORRETO
interface Ferramenta{
    val tipo:String
}
object Faca: Ferramenta{
    override var tipo ="FACA"
}
object Serra: Ferramenta{
    override var tipo ="SERRA"
}
interface TipoParaCortar{
    val tipo:String
}

class Arvore(override val tipo: String = "Arvore") : TipoParaCortar
class Pao( override val tipo: String = "Pao") : TipoParaCortar

class Cortando(private val oQueCortar:TipoParaCortar, private val ferramenta: Ferramenta){
    fun cortar(){
        println("Estou cortando:: ${oQueCortar.tipo} com a ${ferramenta.tipo}")
    }
}

fun main() {
    //jeito errado, tipos incompativeis
    val cortar = Cortar("Vento")
    cortar.cortar()

    //modelo certo, porém existe a necessidade de um aprimoramento
    // pois nada impede neste modelo de parrar um pao e uma serra
    // para isso podemos crar uma nova classe para cortarPao e especificar
    //as ferramentas permitidas
    val serra= Serra
    val arvore = Arvore()
    val cortarCerto = Cortando(arvore,serra)
    cortarCerto.cortar()
}
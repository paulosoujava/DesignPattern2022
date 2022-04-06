package com.paulo.desginpattern.behaviour.observer.example

fun main() {
    val newsLatter = NewsLatter()
    val fnc1 = Funcionario("Paulo", "p@p.com",newsLatter)
    val fnc2 = Funcionario("Bruna", "b@b.com",newsLatter)

    val cli = Cliente("Malu", "m@m.com",newsLatter)

    val par = Parceiro("Ranata", "r@r.com",newsLatter)

    val fornecedor = Fornecedor("Vana", "v@v.com",newsLatter)

    //Envio da primeira mensagem
    newsLatter.addMessage("Primeira mensagem")
    println("######")

    //REMOCAO
    newsLatter.removerObserver(fnc2)

    newsLatter.addMessage("Segunda mensagem")
    println("######")

    //VOLTANDO
    newsLatter.registerObserver(fnc2)

    newsLatter.addMessage("Terceira mensagem")
    println("######")
}
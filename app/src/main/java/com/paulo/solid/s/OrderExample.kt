package com.paulo.solid.s
// JEITO ERRADO

object Item
class OrderWrong {
    fun calculateTotalSum() {}
    fun getItems() {}
    fun getItemsCount(item: Item) {}
    fun deleteItem(item: Item) {}

    fun printOrder() {}
    fun showOrder() {}

    fun load() {}
    fun save() {}
    fun update() {}
    fun delete() {}
}
/*
Como podemos ver a classe acima se tornou um GodClass, faz tudo sabe de tudo
muitas responsabilidades, Reter, Calcular, Salvar....
Violando asim o SRP ( single responsability )
Problemas aqui:
Resposabilidades demais
Alto acoplamento, deixando o sistema engessado e frágil para alteracoes
Dificuldade em implementar testes automatizados
Sem Reusabilidade
Vamos Reverter isso aplicando o SRP
 */
interface OrderProduct{
    fun getItems()
}

class Order: OrderProduct{
    override fun getItems() {}
    fun getItemsCount(item: Item) {}
    fun deleteItem(item: Item) {}
}
class OrderCalculate{
    //abstracao e nao classe concreta no parametro
    fun calculateTotalSum(order: OrderProduct) {}
}
class OrderView{
    fun printOrder() {}
    fun showOrder() {}
}
class OrderRepository{
    fun load() {}
    fun save() {}
    fun update() {}
    fun delete() {}
}
// Cada um cuida do que é seu
// testabilidade indivudual
// reusabilidade ótima
// seja responsavel por aqui que se propoe a fazer
